package com.sbs.exam.sb_app_2022_10_13.controller;

import com.sbs.exam.sb_app_2022_10_13.service.MemberService;
import com.sbs.exam.sb_app_2022_10_13.vo.Member;
import com.sbs.exam.sb_app_2022_10_13.util.Ut;
import com.sbs.exam.sb_app_2022_10_13.vo.ResultData;
import com.sbs.exam.sb_app_2022_10_13.vo.Rq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UsrMemberController {
  private MemberService memberService;
  private Rq rq;

  public UsrMemberController(MemberService memberService, Rq rq) {
    this.memberService = memberService;
    this.rq = rq;
  }

  @RequestMapping("/usr/member/doJoin")
  @ResponseBody
  public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname,
                                   String cellphoneNo, String email) {
    if (Ut.empty(loginId)) {
      return ResultData.from("F-1", "loginId(을)를 입력 해주세요.");
    }

    if (Ut.empty(loginPw)) {
      return ResultData.from("F-2", "loginPw(을)를 입력 해주세요.");
    }

    if (Ut.empty(name)) {
      return ResultData.from("F-3", "name(을)를 입력 해주세요.");
    }

    if (Ut.empty(nickname)) {
      return ResultData.from("F-4", "nickname(을)를 입력 해주세요.");
    }

    if (Ut.empty(cellphoneNo)) {
      return ResultData.from("F-5", "cellphoneNo(을)를 입력 해주세요.");
    }

    if (Ut.empty(email)) {
      return ResultData.from("F-6", "email(을)를 입력 해주세요.");
    }

    ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);


    if (joinRd.isFail()) {
      return (ResultData) joinRd;
    }

    Member member = memberService.getMemberById(joinRd.getData1());

    return ResultData.newData(joinRd, "member", member);
  }

  @RequestMapping("/usr/member/login")
  public String showLogin(HttpSession httpSession) {
    return "usr/member/login";
  }


  @RequestMapping("/usr/member/doLogin")
  @ResponseBody
  public String doLogin(String loginId, String loginPw) {
    if (Ut.empty(loginId)) {
      return Ut.jsHistoryBack("loginId(을)를 입력 해주세요.");
    }

    if (Ut.empty(loginPw)) {
      return Ut.jsHistoryBack("loginPw(을)를 입력 해주세요.");
    }

    Member member = memberService.getMemberByLoginId(loginId);

    if (member == null) {
      return Ut.jsHistoryBack("존재하지 않는 로그인아이디 입니다.");
    }

    if (member.getLoginPw().equals(loginPw) == false) {
      return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
    }

    rq.login(member);

    return Ut.jsReplace(Ut.f("%s님 환영합니다.", member.getNickname()), "/");
  }

  @RequestMapping("/usr/member/doLogout")
  @ResponseBody
  public String doLogout() {
    rq.logout();

    return rq.jsReplace(Ut.f("로그아웃 되었습니다."), "/");
  }

  @RequestMapping("/usr/member/myPage")
  public String showMyPage(HttpSession httpSession) {
    return "usr/member/myPage";
  }

  @RequestMapping("/usr/member/checkPassword")
  public String showCheckPassword(HttpSession httpSession) {
    return "usr/member/checkPassword";
  }

  @RequestMapping("/usr/member/doCheckPassword")
  @ResponseBody
  public String doCheckPassword(String loginPw, String replaceUri) {
    if (Ut.empty(loginPw)) {
      return rq.jsHistoryBack("loginPw(을)를 입력 해주세요.");
    }

    if (rq.getLoginedMember().getLoginPw().equals(loginPw) == false) {
      return rq.jsHistoryBack("비밀번호가 일치하지 않습니다.");
    }

    return rq.jsReplace("", replaceUri);
  }
}


