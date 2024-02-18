package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {
    private JFrame gameWindow;
    public GameWindow(GamePanel gamePanel){
        gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.setFocusable(true);
        gameWindow.add(gamePanel);
        gameWindow.setResizable(false);
        gameWindow.pack();

        gameWindow.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }
        });

        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

    }


}
