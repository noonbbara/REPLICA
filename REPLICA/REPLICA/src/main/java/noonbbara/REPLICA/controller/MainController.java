package noonbbara.REPLICA.controller;

import noonbbara.REPLICA.domain.Content;
import noonbbara.REPLICA.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final ContentService contentService;
    @Autowired
    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<Content> contents = contentService.findContents();
        model.addAttribute("contents", contents);
        return "main";
    }
}
