package app.ui.simple;

import javax.swing.*;
import java.awt.*;

/**
 * アプリを終了確認するウィンドウ
 */
class CloseWindow extends SimpleWindow {

    @Override
    protected final void addComponent() {
        // -------- ラベルの設定 --------
        JLabel messageLabel = new JLabel("アプリを終了します");
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel, BorderLayout.CENTER);
        // ----------------------------

        // -------- ボタンの設定 --------
        JButton yesButton = new JButton("終了する");
        JButton noButton = new JButton("キャンセル");
        // ボタンを押した時に何するか、を定義する
        // はい系のボタンを押したら、アプリ終了
        yesButton.addActionListener(actionEvent -> System.exit(0));
        // いいえ系のボタンを押したら、このウィンドウを閉じる
        noButton.addActionListener(actionEvent -> setVisible(false));
        // ボタンはパネルに一旦配置してからaddする
        // 　はい　いいえ
        // ↑みたいに見せたい
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        // ----------------------------

        add(messagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
