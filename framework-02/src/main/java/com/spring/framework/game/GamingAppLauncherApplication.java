package com.spring.framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring.framework.game")
public class GamingAppLauncherApplication {
    // Pacemen game Bean is define in Pacman class by Component Annotataion
//    @Bean
//    public GamingConsole game() {
//        var game = new PacmanGame();
//        return game;
//    }

//    @Bean
//    public GameRunner run(GamingConsole game) {
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
    public static void main(String[] args) {


        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);){
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

//        context.getBean("game");

//        var game = new MarioGame();

//        var game = new SuperContraGame();
//        var game = new PacmanGame();        // 1. Object Creationg
//        var gameRunner = new GameRunner(game); // 2. object creation + wiring Dependencies
        // Game is a dependency of Game runner class
//        gameRunner.run();
    }
}
