package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class JSONController {

    @RequestMapping("/recreation")
    @ResponseBody
    public String json() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/app/src/main/resources/ValidatedQuestionnaires/recreation.json")));
        // File[] paths;
        // String s = "";
        // File f = new File("/app/src/main/resources/ValidatedQuestionnaires/recreation.json");

        // paths = f.listFiles();
         
        // for(File path:paths) {     
        //     s = s + "\n" + path;
        // }
        return contents;
    }
}

