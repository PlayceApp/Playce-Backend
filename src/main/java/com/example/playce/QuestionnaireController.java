package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {

    @RequestMapping("/recreation")
    public String recreation(@RequestParam(value="name", defaultValue="World") String name) {
        //String contents = new String(Files.readAllBytes(Paths.get("/src/main/resources/ValidatedQuestionnaires/recreation.json")));

        return "hi";
    }
}
