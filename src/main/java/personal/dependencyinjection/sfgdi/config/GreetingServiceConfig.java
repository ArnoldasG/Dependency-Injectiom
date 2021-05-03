package personal.dependencyinjection.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import personal.dependencyinjection.sfgdi.datasource.FakeDataSource;
import personal.dependencyinjection.sfgdi.repositories.EnglishGreetingRepository;
import personal.dependencyinjection.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import personal.dependencyinjection.sfgdi.services.*;
import personal.di.componentscan.PetService;
import personal.di.componentscan.PetServiceFactory;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml") // imports and checks xml file
@Configuration // This tells to component scan that there is a configuration class and this is going
// to define a different bean
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${personal.username}")String username,
                                  @Value("${personal.password}")String password,
                                  @Value("${personal.jdbcurl}")String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return  new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
       return petServiceFactory.getPetService("dog");
    }
    @Bean
//    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    /* @Bean Now this bean defined in sfdgi-config.xml as an example*/
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
