package com.mycom.happyHouse.service.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.happyHouse.dao.board.BoardDao;
import com.mycom.happyHouse.dto.board.BoardDto;
import com.mycom.happyHouse.dto.board.BoardParamDto;
import com.mycom.happyHouse.dto.board.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	@Override
	@Transactional
	public BoardResultDto boardInsert(BoardDto dto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			dao.boardInsert(dto); // useGeneratedKeys="true" keyProperty="boardId"

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	@Transactional
	public BoardResultDto boardUpdate(BoardDto dto) {

		BoardResultDto boardResultDto = new BoardResultDto();
		
		System.out.println("BoardUpdate : " + dto);

		try {
			dao.boardUpdate(dto);

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	@Transactional
	public BoardResultDto boardDelete(int boardId) {
		// 대댓글 삭제 -> 댓글 삭제 -> 게시글 조회수 삭제 -> 게시글 삭제

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			dao.boardReadCountDelete(boardId);
			dao.boardDelete(boardId);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();
		
		System.out.println("board Detail : " + boardParamDto);

		try {
			int userReadCnt = dao.boardUserReadCount(boardParamDto);
			if (userReadCnt == 0) {
				dao.boardUserReadInsert(boardParamDto.getBoardId(), boardParamDto.getUserId());
				dao.boardReadCountUpdate(boardParamDto.getBoardId());
			}

			BoardDto boardDto = dao.boardDetail(boardParamDto);
			if (boardDto.getUserId() == boardParamDto.getUserId()) {
				boardDto.setSameUser(true);
			} else {
				boardDto.setSameUser(false);
			}
			
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto freeBoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.freeBoardList(boardParamDto);
			int count = dao.freeBoardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto QnABoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.QnABoardList(boardParamDto);
			int count = dao.QnABoardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto noticeBoardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.noticeBoardList(boardParamDto);
			int count = dao.noticeBoardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto freeBoardListSearchWord(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.freeBoardListSearchWord(boardParamDto);
			int count = dao.freeBoardListSearchWordTotalCount(boardParamDto);

			boardResultDto.setList(list);
			boardResultDto.setCount(count);

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto QnABoardListSearchWord(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.QnABoardListSearchWord(boardParamDto);
			int count = dao.QnABoardListSearchWordTotalCount(boardParamDto);

			boardResultDto.setList(list);
			boardResultDto.setCount(count);

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

	@Override
	public BoardResultDto noticeBoardListSearchWord(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			List<BoardDto> list = dao.noticeBoardListSearchWord(boardParamDto);
			int count = dao.noticeBoardListSearchWordTotalCount(boardParamDto);

			boardResultDto.setList(list);
			boardResultDto.setCount(count);

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

		return boardResultDto;
	}

}