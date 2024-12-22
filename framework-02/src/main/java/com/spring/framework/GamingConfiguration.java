package com.spring.framework;

import com.spring.framework.game.GameRunner;
import com.spring.framework.game.GamingConsole;
import com.spring.framework.game.MarioGame;
import com.spring.framework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner run(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

//    var game = new MarioGame();
//    var game = new SuperContraGame();
//    var game = new PacmanGame();        // 1. Object Creationg
//    var gameRunner = new GameRunner(game); // 2. object creation + wiring Dependencies
//    // Game is a dependency of Game runner class
//        gameRunner.run();
}
