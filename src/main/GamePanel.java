package main;

import controller.KeyHandler;
import controller.MouseHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.PlayerDirection.*;

public class GamePanel extends JPanel {
    private MouseHandler mouseHandler;
    private int x = 100, y = 100;
    private BufferedImage image;
    private BufferedImage[][] animations;
    private int aniTick,  aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    public GamePanel(){

        this.setPanelSize();

        importImage();
        loadAnimation();

        mouseHandler = new MouseHandler(this);
        this.addKeyListener(new KeyHandler(this));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);

    }

    private void loadAnimation() {
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/res/img.png");

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {

        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }


    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
            }
        }
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    private void setAnimation(){
        if (moving){playerAction = RUNNING;}
        else {playerAction = IDLE;}
    }
    private void updatePos(){
        if (moving){
            switch (playerDir){
                case LEFT: x -= 5;
                    break;
                case RIGHT: x += 5;
                    break;
                case UP: y -= 5;
                    break;
                case DOWN: y += 5;
                    break;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateAnimationTick();

        setAnimation();
        updatePos();

        g.drawImage(animations[playerAction][aniIndex], x, y, 192, 120, null);
    }



}
