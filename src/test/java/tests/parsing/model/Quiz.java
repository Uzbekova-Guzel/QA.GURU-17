package tests.parsing.model;

import com.google.gson.annotations.SerializedName;

public class Quiz {
    public String quiz;
    @SerializedName("questions")
    public Questions questions;

    public static class Questions {
        public String q1;
        public String[] options = {
                "New York Bulls",
                "Los Angeles Kings",
                "Golden State Warriros",
                "Huston Rocket"
        };
        public String answer;
    }
}
