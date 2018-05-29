package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {

    @RequestMapping(
      value = "/recreation", 
      method = RequestMethod.GET, 
      produces = MediaType.APPLICATION_JSON_VALUE
    )

    String getTest() {
        return "./ValidatedQuestionnaires/shopping.json";
    }
}
