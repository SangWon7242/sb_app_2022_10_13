package com.sbs.exam.sb_app_2022_10_13.service;

import com.sbs.exam.sb_app_2022_10_13.repository.BoardRepository;
import com.sbs.exam.sb_app_2022_10_13.vo.Board;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  private BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public Board getBoardById(int id) {
    return boardRepository.getBoardById(id);
  }

}

