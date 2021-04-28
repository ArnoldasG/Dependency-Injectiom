package personal.dependencyinjection.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import personal.dependencyinjection.sfgdi.services.PetService;

@Controller
public class PetController {

    public final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsBest() {
        return petService.getPetType();
    }
}
