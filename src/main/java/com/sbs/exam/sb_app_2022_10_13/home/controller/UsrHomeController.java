package com.sbs.exam.sb_app_2022_10_13.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
  int count;

  public UsrHomeController() {
    count = -1;
  }

  @RequestMapping("/usr/home/getCount")
  @ResponseBody
  public int getCount() {
    return count;
  }

  @RequestMapping("/usr/home/doSetCount")
  @ResponseBody
  public String doSetCount(int count) {
    this.count = count;
    return "count의 값이 " + this.count + "으로 초기화 되었습니다.";
  }

}
