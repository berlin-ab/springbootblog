package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @Autowired
    Animal animal;

    public String makeAnimalSpeak() {
        return animal.speak();
    }

}
