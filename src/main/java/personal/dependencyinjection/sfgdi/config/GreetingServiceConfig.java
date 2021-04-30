package personal.dependencyinjection.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import personal.dependencyinjection.sfgdi.services.ConstructorGreetingService;
import personal.dependencyinjection.sfgdi.services.PropertyInjectedGreetingService;
import personal.dependencyinjection.sfgdi.services.SetterInjectedGreetingService;

@Configuration // This tells to component scan that there is a configuration class and this is going
// to define a different bean
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
