package controller;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.Constants.PlayerDirection.*;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;
    public KeyHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                gamePanel.setDirection(UP);
                break;
            case  KeyEvent.VK_S, KeyEvent.VK_DOWN:
                gamePanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                gamePanel.setDirection(RIGHT);
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                gamePanel.setDirection(LEFT);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W, KeyEvent.VK_UP:
            case  KeyEvent.VK_S, KeyEvent.VK_DOWN:
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                gamePanel.setMoving(false);
                break;
        }
    }
}
