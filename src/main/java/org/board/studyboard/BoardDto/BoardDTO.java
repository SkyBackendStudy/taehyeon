package org.board.studyboard.BoardDto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private String loginID;
    private String title;
    private String contents;
    private Long view;
    private String deleteYn;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .build();
    }

    @Builder
    public BoardDTO(String title, String contents) {
        this.loginID = "thio123";
        this.title = title;
        this.contents = contents;
        this.view = 0L;
        this.deleteYn = "0";
    }
}
