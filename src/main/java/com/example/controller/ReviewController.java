package com.example.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Review;
import com.example.entity.ReviewImage;
import com.example.service.review.ReviewImageService;
import com.example.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    final ReviewService reviewService;
    final ReviewImageService reviewImageService;
    final String format = "reviewController => {}";

    @PostMapping(value = "insert.do")
    public String insertPOST(@ModelAttribute Review review,
    @ModelAttribute ReviewImage reviewimage,
    @RequestParam(name = "file") MultipartFile file) throws IOException {

            reviewimage.setFilesize(file.getSize());
            reviewimage.setFiledata(file.getInputStream().readAllBytes());
            reviewimage.setFiletype(file.getContentType());
            reviewimage.setFilename(file.getOriginalFilename());
    
            log.info(format,review.toString());
            log.info(format,reviewimage.toString()); 
            
            // reviewService.insertReview(review);
            // reviewImageService.insertReviewImage(reviewimage);
            
            return "/member/mypage/mypage";
    }
}
