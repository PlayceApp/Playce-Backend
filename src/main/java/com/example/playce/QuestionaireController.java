package com.example.playce;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionaireController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/questionaire")
    public String getQuestionaire() {
       return new JsonObject(getQuestions());
    }

    private String getQuestions() {
       String questions = "";

       try {
          Scanner scanner = new Scanner(new File("Questionaire.txt"));

          while (scanner.hasNextLine()) {
             questions += scanner.nextLine();
          }

          scanner.close();

       } catch (Exception e) {
          e.printStackTrace();

       }
    }
}
