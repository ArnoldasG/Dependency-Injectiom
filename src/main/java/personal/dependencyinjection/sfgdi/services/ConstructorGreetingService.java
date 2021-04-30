package personal.dependencyinjection.sfgdi.services;


import org.springframework.stereotype.Service;

//@Service - removed annotation and bean described in GreetingServiceConfig (1)
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
