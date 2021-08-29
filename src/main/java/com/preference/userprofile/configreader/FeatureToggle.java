package com.preference.userprofile.configreader;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "toggle")
@Getter
@Setter
@Validated
public class FeatureToggle {

    @NonNull
    private User user;

    @NonNull
    public static class User {
        @NonNull
        @Getter
        @Setter
        private Marketing marketing;
    }


    @NonNull
    public static class Marketing {
        @NotEmpty
        @Getter
        @Setter
        private Boolean preferences;
    }

}
