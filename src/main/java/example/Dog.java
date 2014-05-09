package example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class Dog implements Animal {
    @Override
    public String speak() {
        return "woof";
    }
}
