package app.ui.panel;

import app.ATMActionType;
import app.Application;
import app.ui.ATMFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * アプリのトップ画面
 * ATMで行う行動を選択できる
 * eclipseのswingデザインツールを使用して構築したので、座標直打ちになっている
 * https://blog.goo.ne.jp/siyokuanjin/e/4c29a0e45c3890856175c76219ab2716
 */
public class TopPanel extends JPanel {

    public static final String TAG = TopPanel.class.getSimpleName();
    public static final String BUTTON_TAG = ".top";
    // トップ画像のパス文字列
    private static final String TOP_WOMAN_PATH = "./res/image/top_woman.png";

    // トップ画面のボタンが押された時に利用元に通知するためのリスナークラス
    private ActionListener mListener;

    public TopPanel(ActionListener listener) {
        this.mListener = listener;
        // デフォルトはFlowLayoutがセットされている
        // 座標直打ちをするためにレイアウトマネージャは空にする
        setLayout(null);
        // コンポーネントをパネルに追加する
        addComponent();
    }

    /**
     * コンポーネントをパネルに追加する
     */
    private void addComponent() {
        // ボタンを定義する
        JButton withdrawButton = createTopButton(ATMActionType.WITHDRAW, 40,  80);
        JButton depositButton  = createTopButton(ATMActionType.DEPOSIT , 310, 80);
        JButton inquiryButton  = createTopButton(ATMActionType.INQUIRY , 40,  310);
        JButton transferButton = createTopButton(ATMActionType.TRANSFER, 310, 310);
        // 銀行名が書かれているラベルを定義する
        JLabel bankNameLabel = new JLabel("　" + Application.BANK_NAME);
        bankNameLabel.setFont(new Font("Serif", Font.BOLD, 42));
        bankNameLabel.setBounds(520, 140, 230, 60);
        // ATMのTOP画面に居そうな女性の画像ラベルを定義する
        JLabel womanLabel = new JLabel(new ImageIcon(TOP_WOMAN_PATH));
        womanLabel.setBounds(540, 260, 200, 310);

        add(withdrawButton);
        add(depositButton);
        add(inquiryButton);
        add(transferButton);
        add(bankNameLabel);
        add(womanLabel);
    }

    /**
     * トップ画面に追加するボタンを生成する
     *
     * @param actionType ボタンを押したときに行う行動の種類
     * @param x          ボタンを配置するx座標
     * @param y          ボタンを配置するy座標
     * @return 生成されたJButton
     */
    private JButton createTopButton(ATMActionType actionType, int x, int y) {
        JButton button = new JButton(actionType.getButtonTitle());
        // ボタンの文字のフォントを設定する
        button.setFont(ATMFrame.BUTTON_FONT);
        // ボタンの配置を設定する
        button.setBounds(x, y, 200, 150);
        // ボタンを押した時の処理を設定する
        button.addActionListener(mListener);
        button.setActionCommand(TAG + actionType.toString());

        return button;
    }
}
