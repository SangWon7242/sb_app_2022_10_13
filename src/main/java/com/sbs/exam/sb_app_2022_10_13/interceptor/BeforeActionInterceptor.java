package com.sbs.exam.sb_app_2022_10_13.interceptor;

import com.sbs.exam.sb_app_2022_10_13.vo.Rq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
    Rq rq = new Rq(req, resp);
    req.setAttribute("rq", rq);

    return HandlerInterceptor.super.preHandle(req, resp, handle);
  }
}
