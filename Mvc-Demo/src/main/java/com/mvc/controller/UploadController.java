package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    private static  String UPLOAD_PATH = "D:\\SpringBoot2-UseCase\\Mvc-Demo\\src\\main\\resources\\upload\\";

    @GetMapping("/")
    public String index(){
        return "upload";
    }
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes attributes){
        if (file.isEmpty()){
            //重定向信息暂存到session中
            attributes.addFlashAttribute("message","上传文件不能为空...");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path,bytes);
            attributes.addFlashAttribute("message","upload success...file is " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/result";
    }
@GetMapping("/result")
    public String result(){
        return "result";
    }
}
