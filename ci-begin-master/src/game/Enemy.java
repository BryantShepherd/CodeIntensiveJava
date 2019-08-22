package game;

import game.player.Player;

public class Enemy extends GameObject {
    public int damage;
    public Enemy() {
//        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        renderer = new Renderer("assets/images/enemies/level0/black");
        position.set(-50, -50);
        velocity.set(0, 3);
        velocity.setAngle(Math.toRadians(20));
        hitBox = new BoxCollider(this, 34 - 8, 50 - 8);
        damage = 1;
    }

    @Override
    public void deactivate() {
        super.deactivate();
        EnemyExplosion explosion = new EnemyExplosion();
        explosion.position.set(position.x, position.y);
    }

    @Override
    public void run() {
        super.run();
        this.checkPlayer();
        if (outOfBoundRight() && goingRight()) { //bounce back from right edge
            changeDirectionX();
        }
        else if (outOfBoundLeft() && goingLeft()) { //rename conditions
            changeDirectionX();
        }
    }

    private boolean outOfBoundRight() {
        return position.x > Settings.BACKGROUND_WIDTH - Settings.ENEMY_WIDTH * anchor.x;
    }

    private boolean outOfBoundLeft() {
        return position.x < Settings.ENEMY_WIDTH * anchor.x;
    }

    private boolean goingRight() {
        return velocity.x > 0;
    }

    private boolean goingLeft() {
        return velocity.x < 0;
    }

    private void changeDirectionX() {
        velocity.x *= -1;
    }

    public void checkPlayer() {
        Player player = GameObject.findIntersects(Player.class, this);
        if (player != null) {
            this.deactivate();
            player.takeDamage(damage);
        }
    }

}
