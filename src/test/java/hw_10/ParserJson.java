package hw_10;

import java.util.List;

public class ParserJson {
    public String university;
    public List<Friend> friend;

    public static class Friend{
        public String name;
        public String email;
        public String devId;
        public List<String> hobbies;
        public String address;
        public Integer number;
    }

}
