package com.mycom.happyHouse.controller.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.board.BoardDto;
import com.mycom.happyHouse.dto.board.BoardParamDto;
import com.mycom.happyHouse.dto.board.BoardResultDto;
import com.mycom.happyHouse.service.board.BoardService;
import com.mycom.happyHouse.service.user.JwtService;

@RestController
public class BoardController {

	@Autowired
	BoardService service;
	@Autowired
	JwtService jwtService;

	private static final int SUCCESS = 1;

	@GetMapping(value = "/freeboards")
	private ResponseEntity<BoardResultDto> freeBoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto;

		if (boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.freeBoardList(boardParamDto);
		} else {
			boardResultDto = service.freeBoardListSearchWord(boardParamDto);
		}

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/qnaboards")
	private ResponseEntity<BoardResultDto> QnABoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto;

		if (boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.QnABoardList(boardParamDto);
		} else {
			boardResultDto = service.QnABoardListSearchWord(boardParamDto);
		}

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/noticeboards")
	private ResponseEntity<BoardResultDto> noticeBoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto;

		if (boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.noticeBoardList(boardParamDto);
		} else {
			boardResultDto = service.noticeBoardListSearchWord(boardParamDto);
		}

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping(value = "/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardDetail(@PathVariable int boardId, @RequestHeader Map<String, Object> requestHeader) {

		BoardParamDto boardParamDto = new BoardParamDto();
		boardParamDto.setBoardId(boardId);
		String userId = jwtService.getSubject((String)requestHeader.get("authorization"));
		boardParamDto.setUserId(userId);
		
		BoardResultDto boardResultDto = service.boardDetail(boardParamDto);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/boards")
	private ResponseEntity<BoardResultDto> boardInsert(@RequestBody BoardDto boardDto, HttpServletRequest request) {

		System.out.println(boardDto);

		BoardResultDto boardResultDto = service.boardInsert(boardDto);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardUpdate(@RequestBody BoardDto boardDto, @RequestHeader Map<String, Object> requestHeader) {

		String userId = jwtService.getSubject((String)requestHeader.get("authorization"));

		boardDto.setUserId(userId);

		BoardResultDto boardResultDto = service.boardUpdate(boardDto);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardDelete(@PathVariable int boardId) {
		BoardResultDto boardResultDto = service.boardDelete(boardId);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
