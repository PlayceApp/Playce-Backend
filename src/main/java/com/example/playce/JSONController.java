package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {

    @RequestMapping("/recreation")
    @ResponseBody
    public String json() {
        //String contents = new String(Files.readAllBytes(Paths.get("/vast-wave-50282/src/main/resources/ValidatedQuestionnaires/recreation.json")));
        return System.getProperty("user.dir");
    }
}

