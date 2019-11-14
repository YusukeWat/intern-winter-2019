package app;

import app.ui.menu.MenuFrame;

import javax.swing.*;

public class App {
    public static final String APP_NAME = "何かしらアプリ";
    public static final String APP_VERSION = "0.1";

    public static void main(String[] args) {
        JFrame frame = new MenuFrame(APP_NAME);
        frame.setBounds(100, 100, 800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
