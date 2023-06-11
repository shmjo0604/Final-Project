package com.example.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Reviewview;
import com.example.service.review.ReviewImageService;
import com.example.service.review.ReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/review")
public class RestReviewController {

    @Autowired
    ReviewService rService;

    @Autowired
    ReviewImageService riService;
    final String format = "RestReviewController => {}";

    @GetMapping(value = "/selectreviewOne.json")
    public Map<String, Object> selectreviewOneGET(
            @RequestParam(name = "no", defaultValue = "0") long no,
            @AuthenticationPrincipal User user,
            Model model) {

        Map<String, Object> map = new HashMap<>();
        String id = user.getUsername();
        Reviewview review = rService.selectReviewOne(id, no);

        List<Long> reviewNolist = riService.reviewImagelistNo(no);

        map.put("review", review);
        map.put("reviewNolist", reviewNolist);

        return map;

    }

}
