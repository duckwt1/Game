package controller;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                gamePanel.changeY(-5);
                break;
            case  KeyEvent.VK_S, KeyEvent.VK_DOWN:
                gamePanel.changeY(5);
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                gamePanel.changeX(5);
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                gamePanel.changeX(-5);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
