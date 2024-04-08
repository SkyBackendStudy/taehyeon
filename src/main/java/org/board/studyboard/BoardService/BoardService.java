package org.board.studyboard.BoardService;

import org.board.studyboard.BoardDto.Board;
import org.board.studyboard.BoardDto.BoardDTO;
import org.board.studyboard.BoardDto.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public void saveBoard(BoardDTO boardDTO) {
        boardRepository.save(boardDTO.toEntity());
    }

    @Transactional
    public List<Board> boardContentList(String contents) {
        return boardRepository.findByContentsContaining(contents);
    }

    @Transactional
    public Page<Board> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("no"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return boardRepository.findAllByDeleteYn(pageable,false);
    }

    @Transactional
    public Page<Board> getSearchList(String contents, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("no"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return boardRepository.findByContentsContainingAndDeleteYn(pageable,contents,false);
    }

    @Transactional
    public Board getBoardOne(Long no) {
        return boardRepository.findByNo(no);
    }

    @Transactional
    public Long updateBoard(Long no, BoardDTO params) {
        Board board = boardRepository.findByNo(no);
        board.update(params.getTitle(),params.getContents());
        return no;
    }
}
