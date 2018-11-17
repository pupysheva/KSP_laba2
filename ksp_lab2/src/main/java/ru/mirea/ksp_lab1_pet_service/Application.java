package ru.mirea.ksp_lab1_pet_service;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication
public class Application {
    public static void main(String[] arg){
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);//Создали приложение
        context.getBean(DBService.class).init();
    }
}
