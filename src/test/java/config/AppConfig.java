package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    @Config.Key("webUrl")
    @Config.DefaultValue("http://demowebshop.tricentis.com")
    String getWebUrl();

    @Config.Key("apiUrl")
    @Config.DefaultValue("http://demowebshop.tricentis.com")
    String getApiUrl();

    @Config.Key("userLogin")
    String getUserLogin();

    @Config.Key("userPassword")
    String getUserPassword();

    @Key("token")
    String getToken();
}