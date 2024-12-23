package com.spring.framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole marioGame) {
        this.game = marioGame;
    }

    public void run() {
        System.out.println("Running Game :" + game);
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
