package app;

import app.ui.ATMFrame;

import javax.swing.*;

public class Application {
    public static final String NAME = "ATM";
    public static final String VERSION = "0.1";
    public static final String BANK_NAME = "RITS銀行";

    public static void main(String[] args) {
//        JFrame frame = new MenuFrame();
//        frame.setTitle(NAME);
//        frame.setBounds(100, 100, 800, 600);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel p0 = new TopPanel();
//        p0 = new AuthPanel();
//        frame.add(p0);

        JFrame frame = new ATMFrame();

        frame.setVisible(true);
    }
}
