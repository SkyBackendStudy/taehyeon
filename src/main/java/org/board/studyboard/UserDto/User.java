package org.board.studyboard.UserDto;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    private Long seq;

    @Column(name= "ID")
    private String loginID;

    @Column(name ="PW")
    private String pw;

    @Column(name = "BIRTH")
    private String birth;

    @Column(name = "SEX")
    private Boolean sex;

    @Column(name = "PHONE")
    private String phone;

    @Column(name ="EMAIL")
    private String email;


    @Builder
    public User(Long seq, String loginID, String pw, String birth, Boolean sex, String phone, String email) {
        this.seq = seq;
        this.loginID = loginID;
        this.pw = pw;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }
}
