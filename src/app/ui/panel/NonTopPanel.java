package app.ui.panel;

import app.ui.ATMFrame;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * トップ画面じゃない画面の共通部分となる基底クラス
 * <p>
 * このクラスを継承先も含めて、eclipseのswingデザインツールを使用して構築したので、座標直打ちになっている
 * https://blog.goo.ne.jp/siyokuanjin/e/4c29a0e45c3890856175c76219ab2716
 */
public abstract class NonTopPanel extends JPanel {

    public static final String NEGATIVE_BUTTON_TAG = ".negative";
    public static final String POSITIVE_BUTTON_TAG = ".positive";

    /**
     * コンストラクタ
     *
     * @param concreteClassTag 具象クラスのTag文字列
     * @param listener         ボタン押下時に動作するActionLister
     */
    public NonTopPanel(String concreteClassTag, ActionListener listener) {
        // デフォルトはFlowLayoutがセットされている
        // 座標直打ちをするためにレイアウトマネージャは空にする
        setLayout(null);
        // 画面上部の、具象クラスごとに異なるコンポーネントをパネルに追加する
        addConcreteComponent();
        // 画面下部の、取消・確定ボタンをパネルに追加する
        addButtons(concreteClassTag, listener);
    }

    /**
     * 取消、確定ボタンをパネルに追加する
     *
     * @param concreteClassTag 具象クラスのTag文字列
     * @param listener         ボタン押下時に動作するActionLister
     */
    private void addButtons(String concreteClassTag, ActionListener listener) {
        // -------- 取消ボタンの設定 --------
        JButton mNegativeButton = new JButton("取消");
        mNegativeButton.setFont(ATMFrame.BUTTON_FONT);
        mNegativeButton.setBounds(50, 420, 200, 100);
        mNegativeButton.addActionListener(listener);
        // ボタン押下時のコールバック関数に、識別子を割り当てる
        // 取消ボタンの識別子は、「具象クラスのTag文字列 + 取消ボタン専用のTag文字列」
        mNegativeButton.setActionCommand(concreteClassTag + NEGATIVE_BUTTON_TAG);
        // --------------------------------

        // -------- 確定ボタンの設定 --------
        JButton mPositiveButton = new JButton("確定");
        mPositiveButton.setFont(ATMFrame.BUTTON_FONT);
        mPositiveButton.setBounds(550, 420, 200, 100);
        mPositiveButton.addActionListener(listener);
        // ボタン押下時のコールバック関数に、識別子を割り当てる
        // 確定ボタンの識別子は、「具象クラスのTag文字列 + 確定ボタン専用のTag文字列」
        mPositiveButton.setActionCommand(concreteClassTag + POSITIVE_BUTTON_TAG);
        // --------------------------------

        add(mNegativeButton);
        add(mPositiveButton);
    }

    /**
     * 具象クラスのコンポーネントをパネルに追加する
     * addもこの関数内で行うこと
     */
    protected abstract void addConcreteComponent();
}
