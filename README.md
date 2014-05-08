# Spring Boot from the ground up

I've been playing around with Spring Boot <http://projects.spring.io/spring-boot/> recently.  When I want to try out a new idea, I want a brand new, nothing special installation of Spring Boot.  If I have a minimal version of Spring Boot to start, then I am better able to understand what additional Spring Boot features are providing.

## Fresh Installation

- gradle init:

```
	$ gradle init
```

- edit `build.gradle` and enable the gradle java plugin:

```
	apply plugin: 'java'
```

- create a plain Java application:

```
	$ PROJECT_NAME=example
	$ mkdir -p src/main/java/${PROJECT_NAME}
	$ touch src/main/java/${PROJECT_NAME}/Application.java

	---

	package example;

	public class Application {
	    public static void main(String[] args) {
	    }
	}

```

- edit `build.gradle` and enable the spring boot gradle plugin:

```
	apply plugin: 'spring-boot'

	buildscript {
	    repositories {
	        mavenCentral()
	    }

	    dependencies {
	        classpath("org.springframework.boot:spring-boot-gradle-plugin:1+")
	    }
	}
```

- edit `build.gradle` and add the spring boot dependency:

```
	repositories {
	    mavenCentral()
	}

	dependencies {
	    compile("org.springframework.boot:spring-boot:1+")
	}
```

- run spring boot when you run your application:


```
	package example;

	import org.springframework.boot.SpringApplication;

	public class Application {
	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
	}
```

- try it out

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

	[2014-05-08 12:48:45.400] - 61623 INFO [main] --- example.Application: Starting Application on cliff with PID 61623 (/Users/me/workspace/springbootblog/build/classes/main started by me in /Users/me/workspace/springbootblog)
	[2014-05-08 12:48:45.457] - 61623 INFO [main] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@ed952d1: startup date [Thu May 08 12:48:45 EDT 2014]; root of context hierarchy
	[2014-05-08 12:48:45.532] - 61623 INFO [main] --- example.Application: Started Application in 1.367 seconds (JVM running for 1.523)
	[2014-05-08 12:48:45.535] - 61623 INFO [Thread-1] --- org.springframework.context.annotation.AnnotationConfigApplicationContext: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@ed952d1: startup date [Thu May 08 12:48:45 EDT 2014]; root of context hierarchy

	BUILD SUCCESSFUL

	Total time: 4.987 secs
```
