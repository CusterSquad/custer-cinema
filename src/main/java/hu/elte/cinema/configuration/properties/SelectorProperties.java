package hu.elte.cinema.configuration.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class SelectorProperties {

    @Autowired
    private Environment environment;


    public List<String> getDubbedSelectorList() {
        String temp = environment.getRequiredProperty("isDubbed");
        return Arrays.asList(temp.split(","));
    }
    public List<String> getAgeLimitSelectorList() {
        String temp = environment.getRequiredProperty("agelimit");
        return Arrays.asList(temp.split(","));
    }
}
