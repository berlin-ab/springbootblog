# Configuring a Spring Boot Application using YAML

Ok, so you have a minimal Spring Boot application.  Sometimes you want to configure your application to use non-compiled parameters at runtime.

- edit `build.gradle` and add SnakeYAML as a dependency:

```
    dependencies {
       compile("org.yaml:snakeyaml:1+")

       // other dependencies
    }
```

- create the configuration file:

```
    $ mkdir -p config/
    $ touch -p config/application.yml

    ---

    example:
        someValue: Foobar

```

- Inject a configuration `@Value` into a `@Component`

```
    @Component
    public class Thing {
        @Value("${example.someValue}")
        String someValue;
    }
```


- Let's try it:

```
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        Thing thing = context.getBean(Thing.class);
        System.out.println(thing.someValue);
    }

    ---

    $ gradle bootRun
    :compileJava
    :bootRun

      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::        (v1.0.2.RELEASE)

    [2014-05-08 15:26:13.304] - 31475 INFO [main] --- example.Application: Starting Application on cliff with PID 31475 (/Users/pivotal-mlbam/workspace/springbootblog/build/classes/main started by pivotal-mlbam in /Users/pivotal-mlbam/workspace/springbootblog)
    [2014-05-08 15:26:13.348] - 31475 INFO [main] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@dd86b03: startup date [Thu May 08 15:26:13 EDT 2014]; root of context hierarchy
    [2014-05-08 15:26:13.490] - 31475 INFO [main] --- example.Application: Started Application in 2.476 seconds (JVM running for 2.672)
    ${example.someValue}
    [2014-05-08 15:26:13.492] - 31475 INFO [Thread-1] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@dd86b03: startup date [Thu May 08 15:26:13 EDT 2014]; root of context hierarchy

    BUILD SUCCESSFUL

    Total time: 8.227 secs

```

Did not work.  Sad face.