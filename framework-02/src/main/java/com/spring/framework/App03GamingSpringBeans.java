package com.spring.framework;

import com.spring.framework.game.GameRunner;
import com.spring.framework.game.GamingConsole;
import com.spring.framework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {


        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(GamingConfiguration.class);){
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
