package main;

import controller.KeyHandler;
import controller.MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseHandler mouseHandler;
    private float x = 0, y = 0;
    private float xDir = 0.1f, yDir = 0.1f;
    private Color color;
    private Random random;
    public GamePanel(){

        mouseHandler = new MouseHandler(this);
        this.addKeyListener(new KeyHandler(this));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);

        random = new Random();
    }

    public void changeX(int value){
        this.x += value;

    }
    public void changeY(int value){
        this.y +=value;

    }
    public void setPosition(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect((int) x, (int) y, 20, 20);

        updateRec();

        repaint();
    }

    private void updateRec() {
        x += xDir;
        if (x > 600 || x < 0){
            xDir *= -1;
            color = getRanColor();
        }

        y += yDir;
        if (y > 400 || y < 0){
            yDir *= -1;
            color = getRanColor();
        }
    }

    private Color getRanColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return  new Color(r, g, b);
    }
}
