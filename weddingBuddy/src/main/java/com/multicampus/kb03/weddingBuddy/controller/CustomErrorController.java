package com.multicampus.kb03.weddingBuddy.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";
    @RequestMapping("/error")
    public String handleError() {
        return "error"; // error.html 페이지 또는 다른 오류 처리 페이지로 리턴
    }
}