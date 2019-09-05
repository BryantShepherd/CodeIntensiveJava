package game.screen;

public class ScreenManager {
    public static Screen currentScreen;
    public static void signNewScreen(Screen newScreen) {
        if (currentScreen != null) {
            currentScreen.clear();
        }
        newScreen.init();
        currentScreen = newScreen;
    }
}
