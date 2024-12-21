package com.spring.framework;

import com.spring.framework.game.GameRunner;
import com.spring.framework.game.MarioGame;
import com.spring.framework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
//        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(superContraGame);
        gameRunner.run();
    }
}
