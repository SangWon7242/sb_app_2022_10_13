package com.sbs.exam.sb_app_2022_10_13.service;

import com.sbs.exam.sb_app_2022_10_13.repository.ReplyRepository;
import com.sbs.exam.sb_app_2022_10_13.util.Ut;
import com.sbs.exam.sb_app_2022_10_13.vo.ResultData;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
  private ReplyRepository replyRepository;

  public ReplyService(ReplyRepository replyRepository) {
    this.replyRepository = replyRepository;
  }

  public ResultData<Integer> writeArticle(int actorId, String relTypeCode, int relId, String body) {
    replyRepository.writeArticle(actorId, relTypeCode, relId, body);
    int id = replyRepository.getLastInsertId();

    return ResultData.from("S-1", Ut.f("%d번 댓글이 생성되었습니다.", id), "id", id);
  }
}
