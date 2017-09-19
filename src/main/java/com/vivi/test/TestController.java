package com.vivi.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vivi on 2017/9/10.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/encode1", method = RequestMethod.GET)
    @ResponseBody
    public String encode1() throws Exception{
        return "中文";
    }

    @RequestMapping(value = "/encode2", method = RequestMethod.GET)
    @ResponseBody
    public String encode2(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception{
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        return new String("中文".getBytes("ISO-8859-1"), "UTF-8") + "中文" + request.getCharacterEncoding() + response.getContentType();
    }
}
