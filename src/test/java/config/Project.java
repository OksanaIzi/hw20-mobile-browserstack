package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static final AndroidConfig androidConfig = ConfigFactory
            .create(AndroidConfig.class, System.getProperties());
    public static final BrowserstackConfig browserStackConfig = ConfigFactory
            .create(BrowserstackConfig.class, System.getProperties());
    public static final IosConfig iosConfig = ConfigFactory
            .create(IosConfig.class, System.getProperties());
}
