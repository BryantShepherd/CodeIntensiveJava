import game.GamePanel;
import game.KeyEventPress;
import game.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */

public class Program {
//    static final int WINDOW_WIDTH = 800;
//    static final int WINDOW_HEIGHT = 600;
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        JFrame window = new JFrame();
        //window.setSize(800,600); this will set WINDOWS size (including title bar, border, ...)
        window.setTitle("Game");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = true;
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D  || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }

            }
        }); //what is super?

        GamePanel panel = new GamePanel();
        window.add(panel);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));
        window.pack();
        window.setVisible(true); //need to be at the bottom
        panel.gameLoop();
    }
}

//Lam gaem:
//jframe
//jpanel
//graphics
//shortcut command:
//correct code: alt + enter
//rename all occurrence: shift + F6
//duplicate a line: ctrl + d