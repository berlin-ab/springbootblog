# Autowiring Components in a Spring Boot Application

Ok, so you have a minimal install of Spring Boot:

```
package example;

import org.springframework.boot.SpringApplication;

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Now you want it to do something.  One of the first concepts to learn in the Spring ecosystem is how to do dependency injection.

You need two things:

- something to inject
- something to inject into

Let's start with something to inject.  We'll start by defining a `@Component` class.

```

    $ mkdir -p src/main/java/things/
    $ touch src/main/java/things/Thing.java

    --

    package things;

    import org.springframework.stereotype.Component;

    @Component
    public class Thing {
        public String toString() {
            return "It worked.";
        }
    }
```

Now Let's inject a thing into another thing.

First we need to tell our SpringApplication to go find components.  To do this, we'll use the `@ComponentScan` and `@Configuration` annotations, and we'll tell it to look in our `things` package:

```
    @Configuration
    @ComponentScan("things")
    public class Application {
```

Then, we can ask Spring to automatically place an instance of Thing into other components.  To do this, we'll use the `@Autowired` annotation:

```
    $ touch src/main/java/things/OtherThing.java

    ---

    package things;

    @Component
    public class OtherThing {
         @Autowired
         Thing thing;

         public String toString() {
             return thing.toString();
         }
    }
```

Now, if we grab a hold of an instance of our OtherThing, Spring will automatically inject an instance of Thing as a property of OtherThing:

```
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        OtherThing otherThing = context.getBean(OtherThing.class);
        System.out.println(otherThing.toString());
    }
```


Let's try it.  We should see the application print out "It worked.":

```
    $ gradle bootRun

    :compileJava UP-TO-DATE
    :bootRun

      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::        (v1.0.2.RELEASE)

    [2014-05-08 14:03:46.900] - 52418 INFO [main] --- example.Application: Starting Application on cliff with PID 52418 (/Users/pivotal-mlbam/workspace/springbootblog/build/classes/main started by pivotal-mlbam in /Users/pivotal-mlbam/workspace/springbootblog)
    [2014-05-08 14:03:46.950] - 52418 INFO [main] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@349319f9: startup date [Thu May 08 14:03:46 EDT 2014]; root of context hierarchy
    [2014-05-08 14:03:47.077] - 52418 INFO [main] --- example.Application: Started Application in 2.062 seconds (JVM running for 2.22)
    It worked.
    [2014-05-08 14:03:47.079] - 52418 INFO [Thread-1] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@349319f9: startup date [Thu May 08 14:03:46 EDT 2014]; root of context hierarchy

    BUILD SUCCESSFUL

    Total time: 5.95 secs
```

It worked.