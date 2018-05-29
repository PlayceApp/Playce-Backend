package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {

    @RequestMapping("/recreation")
    public JSON json(@RequestParam(value="name", defaultValue="World") String name) {
        return new JSON("hi");
    }
}

