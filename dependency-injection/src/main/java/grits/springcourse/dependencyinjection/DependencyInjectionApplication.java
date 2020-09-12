package grits.springcourse.dependencyinjection;

import com.sun.org.apache.xml.internal.security.utils.I18n;
import grits.springcourse.dependencyinjection.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);

        I18nController i18nController = (I18nController) applicationContext.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController controller = (MyController) applicationContext.getBean("myController");

        System.out.println("---------- PRIMARY -----------");
        String greeting = controller.getGreeting();
        System.out.println(greeting);

        System.out.println("---------- PROPERTY -----------");
        PropertyInjectedController propertyInjectedController =
                (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------- SETTER -----------");
        SetterInjectedController setterInjectedController =
                (SetterInjectedController) applicationContext.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---------- CONSTRUCTOR -----------");
        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
