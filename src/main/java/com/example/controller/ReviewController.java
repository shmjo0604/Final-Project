package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    @RequestParam(name = "file1")  List<MultipartFile> files) throws IOException {

            List<ReviewImage> list = new ArrayList<>();

            for(MultipartFile multipartfile : files){
                
            reviewimage.setFilesize(multipartfile.getSize());
            reviewimage.setFiledata(multipartfile.getInputStream().readAllBytes());
            reviewimage.setFiletype(multipartfile.getContentType());
            reviewimage.setFilename(multipartfile.getOriginalFilename());

            list.add(reviewimage);
            }
           
            System.out.println(list.toString()+"메롱");
            log.info(format,review.toString());
            log.info(format,reviewimage.toString()); 
            
            // reviewService.insertReview(review);
            // reviewImageService.insertReviewImage(reviewimage);
            
            return "/member/mypage/mypage";
    }
}
