package app.ui.simple;

import javax.swing.*;
import java.awt.*;

public class CloseWindow extends SimpleWindow {

    private final JLabel mLabel = new JLabel("アプリを終了します");
    private final JButton mButtonYes = new JButton("終了する");
    private final JButton mButtonNo = new JButton("キャンセル");

    @Override
    protected void addComponent() {
        // -------- ラベルの設定 --------
        // 文字列を中央に配置したいので、パネルの真ん中に一旦追加する
        JPanel panelL = new JPanel();
        panelL.add(mLabel, BorderLayout.CENTER);
        // ----------------------------

        // -------- ボタンの設定 --------
        // ボタンを押した時に何するか、を定義する
        // はい系のボタンを押したら、アプリ終了
        mButtonYes.addActionListener(actionEvent -> System.exit(0));
        // いいえ系のボタンを押したら、このウィンドウを閉じる
        mButtonNo.addActionListener(actionEvent -> setVisible(false));
        // ボタンはパネルに一旦配置してからaddする
        // 　はい　いいえ
        // ↑みたいに見せたい
        JPanel panelB = new JPanel();
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));
        panelB.add(mButtonYes);
        panelB.add(mButtonNo);
        // ----------------------------

        getContentPane().add(panelL, BorderLayout.CENTER);
        getContentPane().add(panelB, BorderLayout.SOUTH);
    }
}
