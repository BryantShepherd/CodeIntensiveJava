//package game.screen;
//
//import game.GameObject;
//import game.KeyEventPress;
//import game.Renderer;
//import game.Settings;
//
//public class BackgroundGameOver extends GameObject {
//    public BackgroundGameOver() {
//        renderer = new Renderer("assets/images/game_over.png");
//        position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
//    }
//
//    int frameCount;
//    @Override
//    public void run() {
//        super.run();
//        frameCount++;
//        if (KeyEventPress.isAnyKeyPress && frameCount > 60) {
//            ScreenManager.signNewScreen(new WelcomeScreen());
//        }
//    }
//}
