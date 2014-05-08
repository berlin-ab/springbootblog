package example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import things.OtherThing;

@Configuration
@ComponentScan("things")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        OtherThing otherThing = context.getBean(OtherThing.class);
        System.out.println(otherThing.toString());
    }
}