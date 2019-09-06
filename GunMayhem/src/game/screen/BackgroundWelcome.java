//package game.screen;
//
//import game.GameObject;
//import game.KeyEventPress;
//import game.Renderer;
//import game.Settings;
//
//public class BackgroundWelcome extends GameObject {
//    public BackgroundWelcome() {
//        renderer = new Renderer("assets/images/welcome.png");
//        position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        if (KeyEventPress.isAnyKeyPress) {
//            //TODO: sign PlayScreen here
//            ScreenManager.signNewScreen(new PlayScreen());
//        }
//    }
//}
