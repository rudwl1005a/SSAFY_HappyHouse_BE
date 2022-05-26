package com.mycom.happyHouse.dao.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.happyHouse.dto.board.BoardDto;
import com.mycom.happyHouse.dto.board.BoardParamDto;

@Mapper
public interface BoardDao {
	
	// CRUD
	public int boardInsert(BoardDto dto); // 게시물 등록
	// map - Dto
	public int boardUserReadCount(BoardParamDto boardParamDto); // 조회수 등록
	// map - @param
	public int boardUserReadInsert(@Param("boardId") int boardId, @Param("userId") String userId); // 조회수 등록
	
	public int boardReadCountUpdate(int boardId); // 조회수
	
	public BoardDto boardDetail(BoardParamDto boardParamDto); // 게시물 상세정보
	
	public int boardUpdate(BoardDto dto); // 게시물 수정
	
	public int boardDelete(int boardId); // DB에서 게시물 삭제
	public int boardReadCountDelete(int boardId); // 조회수 삭제

	
	// 게시물 목록
	public List<BoardDto> myBoardList(BoardParamDto boardParamDto); // 내 게시물 목록
	public List<BoardDto> freeBoardList(BoardParamDto boardParamDto); // 자유게시물 목록
	public List<BoardDto> QnABoardList(BoardParamDto boardParamDto); // QnA게시물 목록
	public List<BoardDto> noticeBoardList(BoardParamDto boardParamDto); // 공지사항 목록
	
	public int myBoardListTotalCount(String userId); // 내 게시물 전체 개수 (페이징)
	public int freeBoardListTotalCount(); // 자유게시물 전체 개수 (페이징)
	public int QnABoardListTotalCount(); // QnA목록 전체 개수 (페이징)
	public int noticeBoardListTotalCount(); // 공지사항 전체 개수 (페이징)
	
	// 게시물 검색 목록
	public List<BoardDto> myBoardListSearchWord(BoardParamDto boardParamDto); // 내 게시물 검색 결과 게시물 목록
	public List<BoardDto> freeBoardListSearchWord(BoardParamDto boardParamDto); // 자유게시물 검색 결과 게시물 목록
	public List<BoardDto> QnABoardListSearchWord(BoardParamDto boardParamDto); // QnA게시물 검색 결과 게시물 목록
	public List<BoardDto> noticeBoardListSearchWord(BoardParamDto boardParamDto); // 공지사항 검색 결과 게시물 목록
	
	public int myBoardListSearchWordTotalCount(BoardParamDto boardParamDto); // 내 게시물 검색 결과 게시물 개수 (페이징)
	public int freeBoardListSearchWordTotalCount(BoardParamDto boardParamDto); // 자유게시물 검색 결과 게시물 개수 (페이징)
	public int QnABoardListSearchWordTotalCount(BoardParamDto boardParamDto); // QnA게시물 검색 결과 게시물 개수 (페이징)
	public int noticeBoardListSearchWordTotalCount(BoardParamDto boardParamDto); // 공지사항 검색 결과 게시물 개수 (페이징)

}
