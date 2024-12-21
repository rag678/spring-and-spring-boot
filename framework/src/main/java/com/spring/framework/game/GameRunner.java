package com.spring.framework.game;

public class GameRunner {
    private SuperContraGame game;
    public GameRunner(SuperContraGame marioGame) {
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
