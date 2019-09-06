package game;

import game.player.Player1;
import game.player.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program {
    public static void main(String[] args) {
        /* INITIALIZE WINDOW*/
        JFrame window = new JFrame();
        window.setTitle("Gun Mayhem");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //Player 1 Control
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Player1.keyPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    Player1.keyPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Player1.keyPress.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Player1.keyPress.isUpPress = true;
                }
                //Player 2 Control
//                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    Player2.keyPress.isLeftPress = true;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    Player2.keyPress.isDownPress = true;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    Player2.keyPress.isRightPress = true;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    Player2.keyPress.isUpPress = true;
//                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //Player 1 Control
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Player1.keyPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    Player1.keyPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Player1.keyPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Player1.keyPress.isUpPress = false;
                }
                //Player 2 Control
//                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    Player2.keyPress.isLeftPress = false;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    Player2.keyPress.isDownPress = false;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    Player2.keyPress.isRightPress = false;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    Player2.keyPress.isUpPress = false;
//                }
            }
        });

        GamePanel panel = new GamePanel();
        window.add(panel);
        panel.setPreferredSize(new Dimension(900, 600));
        window.pack();
        window.setVisible(true);
        panel.gameLoop();
    }
}
