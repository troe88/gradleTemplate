package com.lebedev.utils.config;

import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

public class GlobalConfig {
    private static TestConfig config = null;

    public static TestConfig get() {
        if(Objects.isNull(config)) {
            config = ConfigFactory.create(TestConfig.class);
        }
        return config;
    }
}
