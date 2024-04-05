package org.board.studyboard;

import jakarta.persistence.EntityNotFoundException;
import org.board.studyboard.BoardDto.Board;
import org.board.studyboard.BoardDto.BoardRepository;
import org.board.studyboard.BoardService.BoardService;
import org.board.studyboard.UserDto.User;
import org.board.studyboard.UserDto.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyBoardApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BoardRepository boardRepository;

	@Test
	void SaveUser() {
		User saveUserA = User.builder()
				.loginID("thio123")
				.pw("1234")
				.birth("950708")
				.sex(true)
				.email("shoe1541@naver.com")
				.phone("010-2665-6305")
				.build();

		User userA = userRepository.save(saveUserA);
		Assertions.assertEquals(userA.getLoginID(), "thio123");
	}

//	@Test
//	void findAll() {
//		userRepository.findAll();
//	}
//
//	@Test
//	void findById() {
//		User userA = userRepository.findById(1L).orElseThrow(()-> new EntityNotFoundException());
//		Assertions.assertEquals(userA.getLoginID(),"thio123");
//
//	}
//
//	@Test
//	void findByContents() {
//		boardRepository.findByContentsLike("테스트");
//	}

	@Test
	void findByNo() {
		Board board = boardRepository.findByNo(2L);
		Assertions.assertEquals(board.getTitle(),"테스트1");

	}

}
