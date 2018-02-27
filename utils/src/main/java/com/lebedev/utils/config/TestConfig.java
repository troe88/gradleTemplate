package com.lebedev.utils.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})
public interface TestConfig extends Config {
    String path();
}
