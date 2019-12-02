package app.ui.simple;

import javax.swing.*;
import java.awt.*;

/**
 * 取引後の結果を表示するウィンドウ
 * SimpleWindowは継承しているが、他のウィンドウとはやや扱いが異なるので、Abstract Factory による管理はしない
 */
public class TransactionWindow extends SimpleWindow {

    private static final TransactionWindow INSTANCE = new TransactionWindow();
    private JLabel label;

    /**
     * このクラスのインスタンスを取得する
     *
     * @return TransactionWindowインスタンス
     */
    public static TransactionWindow getInstance() {
        return INSTANCE;
    }

    @Override
    protected void addComponent() {
        label = new JLabel("残高:    円");

        JButton button = new JButton("OK");
        button.addActionListener(actionEvent -> setVisible(false));

        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    /**
     * 残高を用意する
     *
     * @param amount
     */
    public void setAmount(int amount) {
        label.setText(String.format("残高: %d 円", amount));
    }

    /**
     * 取引失敗の文字列を用意する
     */
    public void setTransactionFailure() {
        label.setText("取引失敗");
    }
}