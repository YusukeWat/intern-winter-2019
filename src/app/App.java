package app;

import app.ui.AtmTopPanel;
import app.ui.menu.MenuFrame;

import javax.swing.*;

public class App {
    public static final String NAME = "ATM";
    public static final String VERSION = "0.1";
    public static final String BANK_NAME = "RITS銀行";

    public static void main(String[] args) {
        JFrame frame = new MenuFrame();
        frame.setTitle(NAME);
        frame.setBounds(100, 100, 800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p0 = new AtmTopPanel();
        frame.add(p0);

        frame.setVisible(true);
    }
}
