package org.board.studyboard.BoardDto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_BOARD")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO")
    private Long no;

    @Column(name= "ID")
    private String loginID;

    @Column(name ="TITLE")
    private String title;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "VIEW")
    private Long view;

    @Column(name = "DELETE_YN")
    private boolean deleteYn;


    public Board update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        return this;
    }

    public Board delete(boolean deleteYn) {
        this.deleteYn = deleteYn;
        return this;
    }

    @Builder
    public Board(String title, String contents) {
        this.loginID = "thio123";
        this.title = title;
        this.contents = contents;
        this.view = 0L;
        this.deleteYn = false;
    }
}
