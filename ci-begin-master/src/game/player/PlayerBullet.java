package game.player;

import game.*;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
//        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        renderer = new Renderer("assets/images/player-bullets/a", 3);
        position.set(0, 0);
        velocity.set(0, -5);
        hitBox = new BoxCollider(this, 24 - 8, 24 - 8);
    }

    @Override
    public void run() {
        super.run();
        this.checkEnemies();
    }

    private void checkEnemies() {
//        Enemy enemy = GameObject.findEnemyIntersect(this);
        Enemy enemy = GameObject.findIntersects(Enemy.class, this);
        if (enemy != null && enemyInBound(enemy)) {
            this.deactivate();
            enemy.deactivate();
        }
    }

    private boolean enemyInBound(Enemy enemy) {
        return enemy.position.x > -Settings.ENEMY_WIDTH * enemy.anchor.x && enemy.position.y > -Settings.ENEMY_HEIGHT * enemy.anchor.y;
    }
}
