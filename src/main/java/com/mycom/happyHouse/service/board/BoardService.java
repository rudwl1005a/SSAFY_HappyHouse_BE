package com.mycom.happyHouse.service.board;

import com.mycom.happyHouse.dto.board.BoardDto;
import com.mycom.happyHouse.dto.board.BoardParamDto;
import com.mycom.happyHouse.dto.board.BoardResultDto;

public interface BoardService {
	
	public BoardResultDto boardDetail(BoardParamDto boardParamDto);
	
	public BoardResultDto boardDelete(int boardId);
	
	public BoardResultDto boardUpdate(BoardDto dto);

	public BoardResultDto boardInsert(BoardDto dto);

	public BoardResultDto freeBoardList(BoardParamDto boardParamDto);
	public BoardResultDto QnABoardList(BoardParamDto boardParamDto);
	public BoardResultDto noticeBoardList(BoardParamDto boardParamDto);
	
	public BoardResultDto freeBoardListSearchWord(BoardParamDto boardParamDto);
	public BoardResultDto QnABoardListSearchWord(BoardParamDto boardParamDto);
	public BoardResultDto noticeBoardListSearchWord(BoardParamDto boardParamDto);

}
