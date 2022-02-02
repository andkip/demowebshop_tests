package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    @Key("webUrl")
    @Config.DefaultValue("http://demowebshop.tricentis.com")
    String getWebUrl();

    @Key("apiUrl")
    @Config.DefaultValue("http://demowebshop.tricentis.com")
    String getApiUrl();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("userLogin")
    String getUserLogin();

    @Key("userPassword")
    String getUserPassword();

    @Key("token")
    String getToken();
}