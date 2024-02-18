package main;

import controller.KeyHandler;
import controller.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private MouseHandler mouseHandler;
    private Game game;

    public GamePanel(Game game){

        this.setPanelSize();

        this.game = game;

        mouseHandler = new MouseHandler(this);
        this.addKeyListener(new KeyHandler(this));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);

    }
    private void setPanelSize() {

        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void updateGame(){

    }
    public Game getGame(){
        return game;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }
}
