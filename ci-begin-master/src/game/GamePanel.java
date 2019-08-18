package game;

import game.player.Player;
import game.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    PlayerBullet bullet;
    Enemy enemy;
    //
    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy = new Enemy();
        //bullet = new PlayerBullet();
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println("paint");
//        g.setColor(Color.RED);
//        g.drawRect(100, 100, 100, 100);
//        g.fillRect(200,200,300,300);
        //Clear canvas
        g.setColor(Color.WHITE);
        g.fillRect(0,0,Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        //Render assets
        GameObject.renderAll(g);

        g.setColor(Color.BLACK);
        g.fillRect(384, 0, 416, Settings.GAME_HEIGHT); //use constant or variables
    }

    public void gameLoop() { //Main Loop
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= 1000/60) { //Cap Framerate at 60
                //System.out.println("Looping..." + (currentTime - lastTime));
                //Render
                repaint(); //call to paint()
                runAll();

                lastTime = currentTime;
            }
            //long currentTime = System.nanoTime();
        }
    }

    public void runAll() {
        GameObject.runAll();
    }
}
