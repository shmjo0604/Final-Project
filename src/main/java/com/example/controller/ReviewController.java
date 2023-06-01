package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.ClassImage;
import com.example.entity.Review;
import com.example.entity.ReviewImage;
import com.example.service.classproduct.ClassManageService;
import com.example.service.review.ReviewImageService;
import com.example.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    @Autowired ResourceLoader resourceLoader;
    @Value("${default.image}") String defaultImg;
    
    final ReviewService reviewService;
    final ReviewImageService reviewImageService;
    final ClassManageService manageService;
    final String format = "reviewController => {}";

    @GetMapping(value = "select.do")
    public String selectPOST(){
        return "/inquery/reviewselect";
    }

    @PostMapping(value = "insert.do")
    public String insertPOST(@ModelAttribute Review review,
    @RequestParam(name = "files",required = false) List<MultipartFile> files)
    throws IOException {
        
            log.info(format,review.toString());
            List<ReviewImage> list = new ArrayList<>();

               if(review != null){
                // reviewService.insertReview(review);
              }

               if(files != null){
                for(MultipartFile multipartfile : files){

                    ReviewImage obj = new ReviewImage();
                    obj.setReview(review);
                    obj.setFilesize(multipartfile.getSize());
                    obj.setFiledata(multipartfile.getInputStream().readAllBytes());
                    obj.setFiletype(multipartfile.getContentType());
                    obj.setFilename(multipartfile.getOriginalFilename());

                    list.add(obj);
            }   
          }
                    log.info(format,list.toString());
                 // reviewImageService.insertReviewImage(list);
         
                 return "redirect:/member/mypage.do?menu=";                       
    }

    @GetMapping(value = "/image")
    public ResponseEntity<byte[]> image(@RequestParam(name = "no", defaultValue = "0") long no)
    throws IOException {
        System.out.println(no);
        ClassImage obj = manageService.selectClassImageOne(no);
        System.out.println(obj);
  
        HttpHeaders headers = new HttpHeaders(); //import org.springframework....
    
        if (obj != null) { // 이미지가 존재하는지 확인
            if (obj.getFilesize() > 0) {
                headers.setContentType(MediaType.parseMediaType(obj.getFiletype()));
                return new ResponseEntity<>(obj.getFiledata(), headers, HttpStatus.OK);
            }
        }

        // 이미지가 없을경우
        InputStream is = resourceLoader.getResource(defaultImg).getInputStream(); // exception발생됨
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(is.readAllBytes(),headers,HttpStatus.OK);
    }

    @GetMapping(value = "/customercenter.do")
    public String customercenterGET(
        @RequestParam(name = "menu", defaultValue = "0") int menu,
        @AuthenticationPrincipal User user,
        Model model
    ) {
        String id = user.getUsername();
        
        if(menu == 0) {
            return "redirect:/test/customercenter.do?menu=1";
        }
    
         if(menu == 1) {
            
        }

        else if(menu == 2) {
    
        }
        model.addAttribute("user", user);

        return "/inquery/customercenter";         
        }

@PostMapping(value = "/customercenter.do")
public String customercenterPOST() {

    return "redirect:/test/customercenter.do?menu=1";
}

}

