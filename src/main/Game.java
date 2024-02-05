package main;

public class Game implements Runnable{
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS = 120;
    public  Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        int frames = 0;
        long lastCheck = System.currentTimeMillis();


        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / timePerFrame;
            lastTime = currentTime;

           if (delta >= 1){
                gamePanel.repaint();
                frames++;
                delta--;
           }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("Fps: " + frames);
                frames = 0;
            }
        }
    }

}
