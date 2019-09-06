package game;

import game.player.Player1;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player1 player1;
    Background background;
    //
    public GamePanel() {
        player1 = new Player1();
        background = new Background();
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println("paint");
        //Clear canvas
        g.setColor(Color.WHITE);
        g.fillRect(0,0,900, 600);

        //Render assets
        background.render(g);
        player1.render(g);

    }

    public void gameLoop() { //Main Loop
        long lastTime = 0;
        while(true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 1000000000/60) { //Cap Framerate at 60
                //Render
                repaint(); //call to paint()
                player1.move();
                player1.run();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
    }
}
