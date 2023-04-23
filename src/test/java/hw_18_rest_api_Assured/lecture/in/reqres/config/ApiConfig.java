package hw_18_rest_api_Assured.lecture.in.reqres.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
        "file:./${env}.properties"
})
public interface ApiConfig extends Config {
    @Key("mainUrl")
    String getMainUrl();
}
