package personal.dependencyinjection.sfgdi.services;


import org.springframework.stereotype.Service;

@Service
public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "Cats Are the Best";
    }
}
