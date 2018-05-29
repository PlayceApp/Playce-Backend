package com.example.playce;

public class JSON {

    private String content;

    public JSON(String content) {
        this.content = content;
    }

    public String getContent() {
        return "{
   "options": {
      "start": "InOutDoor"
   },
   "questions": {
      "InOutDoor": {
         "question": "Would you like to be indoor or outdoor?",
         "shorthand": "InOutDoor",
         "answers": [
            {
               "answer": "Indoor",
               "next": "Active"
            },
            {
               "answer": "Outdoor",
               "next": "Active"
            }
         ],
         "view": "MultiChoiceView"
      },
      "Active": {
         "question": "Would you like the activity to be active?",
         "shorthand": "Active",
         "answers": [
            {
               "answer": "Yes",
               "next": "Distance"
            },
            {
               "answer": "No",
               "next": "Distance"
            }
         ],
         "view": "MultiChoiceView"
      },
      "Distance": {
         "question": "How far are you willing to travel?",
         "shorthand": "Distance",
         "answers": [
            {
               "answer": "< 1 mile",
               "next": "Price"
            },
            {
               "answer": "1-5 miles",
               "next": "Price"
            },
            {
               "answer": "5-10 miles",
               "next": "Price"
            },
            {
               "answer": "10+ miles",
               "next": "Price"
            }
         ],
         "view": "MultiChoiceView"
      },
      "Price": {
         "question": "How much money are you looking to spend?",
         "shorthand": "Price",
         "answers": [
            {
               "answer": "$",
               "next": ""
            },
            {
               "answer": "$$",
               "next": ""
            },
            {
               "answer": "$$$",
               "next": ""
            },
            {
               "answer": "$$$$",
               "next": ""
            }
         ],
         "view": "MultiChoiceView"
      }
   }
}
";
    }
}
