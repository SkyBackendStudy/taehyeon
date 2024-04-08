package org.board.studyboard.Controller;

import org.board.studyboard.BoardDto.Board;
import org.board.studyboard.BoardDto.BoardDTO;
import org.board.studyboard.BoardService.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

//    @GetMapping("/list")
//    public String list(Model model) {
//        List<Board> boardList = boardService.boardList();
//        model.addAttribute("allBoardList",boardList);
//        return "list";
//    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Board> paging = boardService.getList(page);
        model.addAttribute("allBoardList", paging);
        return "list";
    }

    @GetMapping("/list/create")
    public String create() {
        return "create";
    }

    @PostMapping("/list/create")
    public String create(BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return "redirect:/list";
    }

//    @GetMapping("/list/search")
//    public String listContents(@RequestParam(value = "keyword") String keyword, Model model) {
//        List<Board> boardContetList = boardService.boardContentList(keyword);
//        model.addAttribute("allBoardList",boardContetList);
//        return "list";
//    }

    @GetMapping("/list/search")
    public String listContents(@RequestParam(value = "keyword") String keyword, @RequestParam(value="page", defaultValue="0") int page, Model model) {
        model.addAttribute("allBoardList",boardService.getSearchList(keyword,page));
        return "list";
    }

    @GetMapping("/list/view/{no}")
    public String updateView(Model model, @PathVariable(value="no") Long no) {
        model.addAttribute("boardOne",boardService.getBoardOne(no));
        return "view";
    }

    @PostMapping("/list/view/{no}")
    public String save(@PathVariable(value="no") Long no, BoardDTO params) {
        boardService.updateBoard(no,params);
        return "redirect:/list/view/{no}";
    }

//    @GetMapping("/list/view")
//    public String updateView() {
//        return "view";
//    }

}
