package main;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(GamePanel gamePanel){
        JFrame gameWindow = new JFrame();
        gameWindow.setSize(600,400);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        gameWindow.add(gamePanel);

        gameWindow.setVisible(true);

    }


}
