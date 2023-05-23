package com.multicampus.kb03.weddingBuddy.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.weddingBuddy.dto.Planner;
import com.multicampus.kb03.weddingBuddy.dto.Top3Vo;
import com.multicampus.kb03.weddingBuddy.dto.User;
import com.multicampus.kb03.weddingBuddy.service.PlannerService;
import com.multicampus.kb03.weddingBuddy.service.UserService;

@Controller
public class FindController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FindController.class);

    private static final int PAGE_SIZE = 3; // 한 페이지에 표시할 플래너 수

    @Autowired
    private PlannerService plannerService;

    @RequestMapping(value = "/search/planner")
    public String findPlannerGet(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "type", required = false) String searchType,
                                 @RequestParam(value = "search", required = false) String searchKeyword,
                                 Model model) throws Exception {
        List<Planner> foundPlanners;
        int totalPlanners;

        if ("area".equals(searchType)) {
            // 지역 검색 로직
            foundPlanners = plannerService.searchByAd(searchKeyword);
        } else if ("name".equals(searchType)) {
            // 이름 검색 로직
            foundPlanners = plannerService.searchByName(searchKeyword);
        } else if ("group".equals(searchType)) {
            // 소속 검색 로직
            foundPlanners = plannerService.searchByGroup(searchKeyword);
        } else {
            // 검색 유형이 잘못된 경우 기본 검색 로직 수행
            foundPlanners = plannerService.selectAll();
        }

        totalPlanners = foundPlanners.size();

        // 페이지네이션 계산
        int totalPages = (int) Math.ceil((double) totalPlanners / PAGE_SIZE);
        int startIndex = (page - 1) * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, totalPlanners);

        // 페이징된 플래너 목록 가져오기
        List<Planner> pagedPlanners = foundPlanners.subList(startIndex, endIndex);

        model.addAttribute("PlannerAll", pagedPlanners);
        model.addAttribute("type", searchType);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "planner_search";
    }

    @PostMapping("/search/planner")
    public String findPlannerPost(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam("type") String searchType,
                                  @RequestParam("search") String searchKeyword,
                                  Model model) throws Exception {
        return findPlannerGet(page, searchType, searchKeyword, model);
    }
}
