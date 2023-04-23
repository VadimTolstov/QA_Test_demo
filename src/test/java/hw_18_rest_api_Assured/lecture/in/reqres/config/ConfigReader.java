package hw_18_rest_api_Assured.lecture.in.reqres.config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final ApiConfig apiConfig = ConfigFactory.create(
            ApiConfig.class,
            System.getProperties()
    );

    public ApiConfig read(){return apiConfig;}
}
