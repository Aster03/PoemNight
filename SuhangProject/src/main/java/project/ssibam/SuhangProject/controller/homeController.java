package project.ssibam.SuhangProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    //가장 기본 홈페이지를 띄워줍니다
    @GetMapping("/")
    public String home() { return "mainP"; }
}
