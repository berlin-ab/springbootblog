package example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class Cat implements Animal {
    @Override
    public String speak() {
        return "Meow";
    }
}
