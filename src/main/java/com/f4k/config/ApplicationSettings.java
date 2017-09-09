package com.f4k.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by pthanhtrung on 12/27/2016.
 */
@Component
@ConfigurationProperties(prefix = "flying.sh4rk")
public class ApplicationSettings {

}
