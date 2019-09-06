package game.screen;

import game.Background;
import game.EnemySummoner;
import game.GameObject;
import game.player.Player;

public class PlayScreen extends Screen {
    @Override
    public void init() {
        new Background();
        new Player();
        new EnemySummoner();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
