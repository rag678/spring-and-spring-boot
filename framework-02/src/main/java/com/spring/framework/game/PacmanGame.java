package com.spring.framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{
    public void up(){
        System.out.println("Up");
    }
    public void down(){
        System.out.println("Go inside");
    }
    public void left(){
        System.out.println("Go Left");
    }
    public void right(){
        System.out.println("Acceralated");
    }
}
