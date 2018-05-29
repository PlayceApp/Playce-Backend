package com.example.playce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

@RestController
public class JSONController {

    @RequestMapping("/recreation")
    @ResponseBody
    public String json() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/app/src/main/resources/ValidatedQuestionnaires/recreation.json")));
        return contents;
    }

    @RequestMapping("/restaurant")
    @ResponseBody
    public String json() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/app/src/main/resources/ValidatedQuestionnaires/restaurant.json")));
        return contents;
    }

    @RequestMapping("/shopping")
    @ResponseBody
    public String json() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/app/src/main/resources/ValidatedQuestionnaires/shopping.json")));
        return contents;
    }
}


