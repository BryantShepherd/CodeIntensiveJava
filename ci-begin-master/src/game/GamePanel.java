package game;

import game.player.Player;
import game.player.PlayerBullet;
import game.screen.PlayScreen;
import game.screen.ScreenManager;
import game.screen.WelcomeScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    PlayerBullet bullet;

    //
    public GamePanel() {
//        background = new Background();
//        player = new Player();
//        new EnemySummoner();
        ScreenManager.signNewScreen(new WelcomeScreen());
        //bullet = new PlayerBullet();
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println("paint");
        //Clear canvas
        g.setColor(Color.WHITE);
        g.fillRect(0,0,Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        //Render assets
        GameObject.renderAll(g);

        if (ScreenManager.currentScreen instanceof PlayScreen) {
            g.setColor(Color.BLACK);
            g.fillRect(384, 0, 416, Settings.GAME_HEIGHT); //use constant or variables
        }
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
