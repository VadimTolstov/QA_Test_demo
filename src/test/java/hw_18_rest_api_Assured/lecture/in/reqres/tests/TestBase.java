package hw_18_rest_api_Assured.lecture.in.reqres.tests;

import hw_18_rest_api_Assured.lecture.in.reqres.config.ConfigReader;
import hw_18_rest_api_Assured.lecture.in.reqres.config.Specification;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void setEnvironment(){
        System.setProperty("env","prod");
        Specification.initSpecification(Specification.requestSpecification(ConfigReader.Instance.read().getMainUrl()));
    }
}
