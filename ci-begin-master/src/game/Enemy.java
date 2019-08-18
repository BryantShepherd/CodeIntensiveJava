package game;

import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
//        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        renderer = new Renderer("assets/images/enemies/level0/black");
        position.set(200, 200);
        velocity.set(0, 0);
        hitBox = new BoxCollider(this, 34, 50);
    }

    @Override
    public void deactivate() {
        super.deactivate();
        EnemyExplosion explosion = new EnemyExplosion();
        explosion.position.set(position.x, position.y);
    }

}
