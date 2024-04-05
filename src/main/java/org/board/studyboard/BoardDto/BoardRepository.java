package org.board.studyboard.BoardDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByContentsContaining(String contentsTitle);

    Page<Board> findAllByDeleteYn(Pageable pageable,boolean deleteYn);
    Page<Board> findByContentsContainingAndDeleteYn(Pageable pageable, String contents,boolean deleteYn);

    Board findByNo(Long no);
}
