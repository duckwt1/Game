package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable{
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS = 120;
    private final int  UPS = 200;
    private Player player;
    public Game(){
        init();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();
    }

    private void init() {
        player = new Player(200, 200);
    }
    public void render(Graphics g){
        player.render(g);
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }



    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        double deltaF = 0, deltaU = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        int frames = 0;
        int  ups  = 0;

        long lastCheck = System.currentTimeMillis();


        while (gameThread != null){
            currentTime = System.nanoTime();

            deltaF += (currentTime - lastTime) / timePerFrame;
            deltaU += (currentTime - lastTime) / timePerUpdate;

            lastTime = currentTime;

            if (deltaU >= 1){
                updates();
                ups++;
                deltaU--;
            }

           if (deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
           }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("Fps: " + frames + "| UPS: " + ups);
                frames = 0;
                ups = 0;
            }
        }
    }

    private void updates() {
        player.update();
    }
    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
