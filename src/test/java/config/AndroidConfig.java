package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/android.properties"
})
public interface AndroidConfig extends Config {

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("app")
    String getApp();
}
