package com.spring.framework;

import com.spring.framework.game.GameRunner;
import com.spring.framework.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();        // 1. Object Creationg
        var gameRunner = new GameRunner(game); // 2. object creation + wiring Dependencies
        // Game is a dependency of Game runner class
        gameRunner.run();
    }
}
