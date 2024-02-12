package main;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame gameWindow;
    public GameWindow(GamePanel gamePanel){
        gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.setFocusable(true);
        gameWindow.add(gamePanel);
        gameWindow.setResizable(false);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

    }


}
