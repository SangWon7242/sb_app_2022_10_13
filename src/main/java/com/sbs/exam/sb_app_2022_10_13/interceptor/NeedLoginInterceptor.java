package com.sbs.exam.sb_app_2022_10_13.interceptor;

import com.sbs.exam.sb_app_2022_10_13.vo.Rq;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class NeedLoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
    System.out.println("로그인 필요");

    return HandlerInterceptor.super.preHandle(req, resp, handle);
  }
}
