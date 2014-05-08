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


