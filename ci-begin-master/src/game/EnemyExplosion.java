package game;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion() {
        renderer = new Renderer("assets/images/enemies/explosion", 5, true);
    }

//    @Override
//    public void deactivate() {
//        super.deactivate();
//        EnemyExplosion explosion = new EnemyExplosion();
//        explosion.position.set(position.x, position.y);
//    }
}
