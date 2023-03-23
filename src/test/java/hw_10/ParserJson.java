package hw_10;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class ParserJson {
    public List<Integer> array;
    public List<Friend> friend;

    public static class Friend{
        public String name;
        public String email;
        public String devId;
        public List<String> hobbies;
        public String address;
    }

    public Boolean id;
    public String color;
    public String date;
    public Integer number;
    @JsonProperty("boolean")
    public boolean myboolean;
    @JsonProperty("null")
    public String mynull;
    public String string;

}
