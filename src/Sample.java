import javax.swing.*;

public class Sample {
    public static final String APP_NAME = "TODOアプリ";
    public static final String APP_VERSION = "1.0";

    public static void main(String[] args) {
        JFrame frame = new MenuFrame();
        frame.setTitle(APP_NAME);
        frame.setBounds(100, 100, 800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
