package project.ssibam.SuhangProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import project.ssibam.SuhangProject.PoemForm;
import project.ssibam.SuhangProject.domain.PoemNightMember;
import project.ssibam.SuhangProject.service.PoemService;

import java.util.ArrayList;

@Controller
public class PoemController {
    /*private final Logger logger = LoggerFactory.getLogger(this.getClass());*/
    private PoemService ps;

    @Autowired
    public PoemController(PoemService ps) { this.ps = ps; }

    // 글 읽기 페이지 매핑
    @GetMapping("/Poem/read")
    public String PoemRead(Model model) {
        ArrayList<PoemNightMember> list = ps.printMembers();
        model.addAttribute("poemlist", list);

        return "readP";
    }

    // 제목&작가명으로 검색하기 위한 매핑
    @PostMapping("/Poem/read")
    public String PoemSearch(String type, String input, Model model) {
        switch (type) { // 제목이냐 작가명이냐에 따라 그에 맞는 결과값을 얻기 위한 메소드 사용
            case "제목":
                ArrayList<PoemNightMember> tiList = ps.findByTitle(input);
                model.addAttribute("poemlist", tiList);
                break;
            case "작가명":
                ArrayList<PoemNightMember> auList = ps.findByAuthor(input);
                model.addAttribute("poemlist", auList);
                break;
            default:
                ArrayList<PoemNightMember> alList = ps.printMembers();
                model.addAttribute("poemlist", alList);
                break;
        }
        return "readP"; // ArrayList만들고 읽기 페이지 호출
    }

    @GetMapping("/Poem/write")
    public String PoemWrite() { return  "writeP"; }

    @PostMapping("/Poem/write")
    public String PoemWriting(PoemForm pf) {
        PoemNightMember pm = new PoemNightMember();
        pm.setTitle(pf.getTitle());
        pm.setAuthor(pf.getAuthor());
        pm.setContents(pf.getContents());
        ps.join(pm);

        return "redirect:/";
    }

    @GetMapping("/Poem/delete")
    public String DeletePoem() { return "deleteP"; }

    @GetMapping("/Poem/delete/search")
    public String dPoemSearch(@RequestParam("id") int id, Model model) {
        PoemNightMember info = ps.findById(id);
        model.addAttribute("info", info);
        return "deleteP";
    }

    @PostMapping("/Poem/delete/real")
    public String realDeletePoem(PoemForm pf) {
        PoemNightMember pm = new PoemNightMember();
        pm.setTitle(pf.getTitle());
        pm.setAuthor(pf.getAuthor());
        pm.setContents(pf.getContents());

        ps.deletePoem(pm);
        return "redirect:/Poem/readP";
    }
}
