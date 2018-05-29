package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.*;
// import java.io.File;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.io.IOException;

@RestController
public class JSONController {

    // @RequestMapping("/recreation")
    // @ResponseBody
    // public String json() throws IOException {
    //     String contents = new String(Files.readAllBytes(Paths.get("/app/src/main/resources/ValidatedQuestionnaires/recreation.json")));
    //     return contents;
    // }

    @RequestMapping(value = "/app/src/main/resources/ValidatedQuestionnaires/recreation.json", method = RequestMethod.GET)
    @ResponseBody 
    public FileSystemResource getFile(@PathVariable("recreation.json") String fileName) {
        return new FileSystemResource(myService.getFileFor(fileName)); 
    }
}


