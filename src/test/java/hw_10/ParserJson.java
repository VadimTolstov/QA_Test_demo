package hw_10;

import java.util.List;

public class ParserJson {
    public String university;
    public List<Friends> friends;

    public static class Friends {
        public String name;
        public String email;
        public String devId;
        public List<String> hobbies;
        public String address;
        public Long number;
    }

}
