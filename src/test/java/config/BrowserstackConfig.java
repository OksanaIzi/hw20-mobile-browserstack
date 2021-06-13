package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("url")
    String url();

    @Key("bs.user")
    String getBaseUser();

    @Key("bs.password")
    String getBasePassword();

    @Key("sessions.url")
    String sessionsUrl();
}
