package com.sbs.exam.sb_app_2022_10_13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
  @RequestMapping("/usr/home/main")
  public String showMain() {
    return "usr/home/main";
  }

  @RequestMapping("/")
  public String showRoot() {
    return "redirect:/usr/home/main";
  }

}


