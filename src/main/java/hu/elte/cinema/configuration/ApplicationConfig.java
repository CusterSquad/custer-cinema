package hu.elte.cinema.configuration;


import hu.elte.cinema.configuration.properties.SelectorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@ComponentScan(basePackages = {"hu.elte.cinema.converter.dto", "hu.elte.cinema.converter.model"})
@Import({ServiceConfig.class, ThymeleafConfig.class})
public class ApplicationConfig {

    @Bean
    ConversionService conversionService() {
        return new DefaultConversionService();
    }
    @Bean
    ConverterRegister converterRegister() {
        return new ConverterRegister();
    }
}
