package org.ec;

import io.smallrye.config.ConfigMapping;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ConfigMapping(prefix = "app")
public interface CustomConfig {

    @ConfigProperty(name = "message")
    String message();

    @ConfigProperty(name = "message2")
    String message2();

}
