package controller;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setUp(true);
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(true);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(false);
                break;
        }

    }
}
