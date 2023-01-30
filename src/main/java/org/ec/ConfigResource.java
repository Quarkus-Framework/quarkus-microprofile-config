package org.ec;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ConfigResource {

    @Inject
    @ConfigProperty(name="config.message.inject", defaultValue = "Hello default value")
    String message;

    @Inject
    CustomConfig customConfig;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getConfigInject() {
        return message;
    }

    @GET
    @Path("/provider")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessageByConfigProvider() {
        Config config = ConfigProvider.getConfig();
        return config.getValue("config.message.provider", String.class);
    }

    @GET
    @Path("/providerOptional")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessageByConfigProviderOptional() {
        return ConfigProvider.getConfig().getOptionalValue("config.message.provider", String.class).orElse("");
    }

    @GET
    @Path("/custom")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCustomConfigMessage() {
        return customConfig.message() + " " +customConfig.message2();
    }
}