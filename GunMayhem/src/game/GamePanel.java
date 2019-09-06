package game;

import game.player.Player1;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player1 player1;

    //
    public GamePanel() {
        player1 = new Player1();
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println("paint");
        //Clear canvas
        g.setColor(Color.WHITE);
        g.fillRect(0,0,900, 600);

        //Render assets
        //GameObject.renderAll(g);

//        if (ScreenManager.currentScreen instanceof PlayScreen) {
//            g.setColor(Color.BLACK);
//            g.fillRect(384, 0, 416, Settings.GAME_HEIGHT); //use constant or variables
//        }
    }

    public void gameLoop() { //Main Loop
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= 1000/60) { //Cap Framerate at 60
                //Render
                repaint(); //call to paint()
                player1.move();

                lastTime = currentTime;
            }
            //long currentTime = System.nanoTime();
        }
    }

    public void runAll() {
    }
}
