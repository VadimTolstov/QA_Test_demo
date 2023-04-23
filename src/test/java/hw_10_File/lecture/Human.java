package hw_10_File.lecture;

/*{
  "name": "Dima",
  "age": 33,
  "isClever": true,
  "hobbies": ["Football", "Beer"],
  "passport": {
    "number": 3242453425,
    "issueDate": "14 JAN 2021"
  }
}

 */

import java.util.List;

public class Human {
    public String name;
    public Integer age;
    public Boolean isClever;
    public List <String> hobbies;
    public Passport passport;

    public static class Passport {
        public Long number;
        public String issuDate;
    }



}
