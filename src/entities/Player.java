package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{
    private BufferedImage[][] animations;
    private int aniTick,  aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false, attacking = false;
    private boolean up, down, right, left;
    private float playerSpeed = 2.0f;
    public Player(float x, float y) {
        super(x, y);
        loadAnimation();
    }
    public void update(){
        updatePos();
        updateAnimationTick();
        setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 192, 120, null);
    }
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
                attacking = false;
            }
        }
    }
    private void setAnimation(){

        int startAni = playerAction;

        if (moving){playerAction = RUNNING;}
        else {playerAction = IDLE;}

        if (attacking){
            playerAction = ATTACK_1;
        }

        if (startAni != playerAction){
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniIndex = 0;
        aniTick = 0;
    }

    private void updatePos(){

        moving = false;

        if ( left && !right){
            x -= playerSpeed;
            moving = true;
        } else if ( right && !left){
            x += playerSpeed;
            moving = true;
        }

        if (up && !down){
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }
    }
    private void loadAnimation(){

            InputStream is = getClass().getResourceAsStream("/res/img.png");

            try {
               BufferedImage image = ImageIO.read(is);

                animations = new BufferedImage[9][6];

                for (int j = 0; j < animations.length; j++) {
                    for (int i = 0; i < animations[j].length; i++) {
                        animations[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    public BufferedImage[][] getAnimations() {
        return animations;
    }

    public void setAnimations(BufferedImage[][] animations) {
        this.animations = animations;
    }
    public void resetDirBooleans(){
        left = false;
        right = false;
        down = false;
        up = false;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
