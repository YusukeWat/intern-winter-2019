package app;

import app.ui.ATMFrame;

import javax.swing.*;

public class Application {
    public static final String NAME = "ATMアプリ";
    public static final String VERSION = "1.0";
    public static final String BANK_NAME = "RITS銀行";

    public static void main(String[] args) {
        JFrame frame = new ATMFrame();
        frame.setVisible(true);
    }
}
