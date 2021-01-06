public class GameData {
    public static int windowWidth = 800;
    public static int windowHeight = 600;
    public static final String title = "Pong pong pong pong";
    public static int fontSize = (int)((windowWidth * windowWidth) / windowHeight * 0.01875);
    public static int menuPaddingW = 20;
    public static int menuPaddingH = 20;
    public static int gamePaddingW = 20;
    public static int gamePaddingH = 150;
    public static int menuRectTitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.175);
    public static int menuRectSubtitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.075);
    public static int menuRectOptionH = windowHeight - (menuPaddingH * 2) - menuRectTitleH - menuRectSubtitleH;
}
