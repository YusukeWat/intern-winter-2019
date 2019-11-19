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
        JLabel label = new JLabel("アプリを終了します");
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel panelL = new JPanel();
        panelL.add(label, BorderLayout.CENTER);
        // ----------------------------

        // -------- ボタンの設定 --------
        JButton buttonYes = new JButton("終了する");
        JButton buttonNo = new JButton("キャンセル");
        // ボタンを押した時に何するか、を定義する
        // はい系のボタンを押したら、アプリ終了
        buttonYes.addActionListener(actionEvent -> System.exit(0));
        // いいえ系のボタンを押したら、このウィンドウを閉じる
        buttonNo.addActionListener(actionEvent -> setVisible(false));
        // ボタンはパネルに一旦配置してからaddする
        // 　はい　いいえ
        // ↑みたいに見せたい
        JPanel panelB = new JPanel();
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));
        panelB.add(buttonYes);
        panelB.add(buttonNo);
        // ----------------------------

        getContentPane().add(panelL, BorderLayout.CENTER);
        getContentPane().add(panelB, BorderLayout.SOUTH);
    }
}
