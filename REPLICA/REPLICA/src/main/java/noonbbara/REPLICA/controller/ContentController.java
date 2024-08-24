package noonbbara.REPLICA.controller;

import noonbbara.REPLICA.domain.Content;
import noonbbara.REPLICA.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {
    private final ContentService contentService;
    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/contents/new")
    public String createForm(){
        return "contents/createContentForm";
    }
    @PostMapping("/contents/new")
    public String create(ContentForm form){
        Content content = new Content();
        content.setMusic(form.getMusic());
        content.setArtist(form.getArtist());
        content.setDate(form.getDate());
        content.setPlace(form.getPlace());
        content.setDescription(form.getDescription());

        contentService.write(content);

        return "redirect:/";
    }

    @GetMapping("/contents")
    public String list(Model model){
        List<Content> contents = contentService.findContents();
        model.addAttribute("contents", contents);
        return "main";
    }
}
