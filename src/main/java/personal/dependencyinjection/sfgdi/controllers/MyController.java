package personal.dependencyinjection.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import personal.dependencyinjection.sfgdi.services.GreetingService;

@Controller
public class MyController {

    private final GreetingService greetingService;

    @Autowired
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){


        return greetingService.sayGreeting();
    }
}
