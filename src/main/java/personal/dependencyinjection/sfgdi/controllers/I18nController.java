package personal.dependencyinjection.sfgdi.controllers;

// I18N - Internationalization - produkto, programos ar dokumento turinio dizainas ir tobulinimas
// kuris leidžia lokalizuoti tikslinę auditoriją, kuri skiriasi kultūra, regionu ar kalba


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import personal.dependencyinjection.sfgdi.services.GreetingService;

@Controller
public class I18nController {

    private final GreetingService greetingService;

    @Autowired
    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
