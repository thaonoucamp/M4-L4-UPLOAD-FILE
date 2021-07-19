package controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @GetMapping("/home")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam MultipartFile img) throws IOException {
        String fileName = img.getOriginalFilename();
        FileCopyUtils.copy(img.getBytes(), new File("/Users/thaodangxuan/upload-file/src/main/webapp/newFileImage/" + fileName));

        ModelAndView modelAndView = new ModelAndView("/upload");
        modelAndView.addObject("img", fileName);

        return modelAndView;
    }
}
