package game.player;

import game.BoxCollider;
import game.Enemy;
import game.GameObject;
import game.Renderer;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
//        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        renderer = new Renderer("assets/images/player-bullets/a", 3);
        position.set(0, 0);
        velocity.set(0, -5);
        hitBox = new BoxCollider(this, 24, 24);
    }

    @Override
    public void run() {
        super.run();
        this.checkEnemies();
    }

    private void checkEnemies() {
        Enemy enemy = GameObject.findEnemyIntersect(this);
        if (enemy != null) {
            this.deactivate();
            enemy.deactivate();
        }
    }
}
