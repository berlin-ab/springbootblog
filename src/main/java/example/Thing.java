package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Thing {

    @Value("${example.someValue}")
    String someValue;

}
