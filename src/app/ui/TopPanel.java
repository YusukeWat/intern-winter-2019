package app.ui;

import app.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {

    public static final String TAG = TopPanel.class.getSimpleName();
    // トップ画像のパス文字列
    private static final String TOP_WOMAN_PATH = "./res/image/top_woman.png";

    // トップ画面のボタンが押された時に利用元に通知するためのリスナークラス
    private ActionListener listener;

    public TopPanel(ActionListener listener) {
        this.listener = listener;
        // このパネル自体のレイアウトを設定する
        // 画面を 左、中央、右 に3分割する
        setLayout(new GridLayout(1, 3));
        // 左、中央、右の順に用意しているパネルを追加する
        add(getPanelOf(Position.LEFT));
        add(getPanelOf(Position.CENTER));
        add(getPanelOf(Position.RIGHT));
    }

    /**
     * 引数に指定した位置のパネルを取得する
     *
     * @param position 左、中央、右のいずれか
     * @return 引数に指定した位置のパネル
     */
    private JPanel getPanelOf(Position position) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        switch (position) {
            case LEFT:
                addLeftComponent(panel);
                break;
            case CENTER:
                addCenterComponent(panel);
                break;
            case RIGHT:
                addRightComponent(panel);
                break;
        }

        return panel;
    }

    /**
     * 左用のコンポーネントを引数のパネルに追加する
     *
     * @param panel コンポーネントを追加するパネル
     * @return コンポーネントを追加したパネル
     */
    private JPanel addLeftComponent(JPanel panel) {
        // バグのヒント
//        panel = new JPanel();
        // お引出しボタンを定義する
        JButton buttonWithdraw = createTopButton(ButtonType.WITHDRAW.title);
        // 残高照会ボタンを定義する
        JButton buttonInquiry = createTopButton(ButtonType.INQUIRY.title);

        // パネルに上記コンポーネントを追加する
        panel.add(buttonWithdraw);
        panel.add(buttonInquiry);

        return panel;
    }

    /**
     * 中央用のコンポーネントを引数のパネルに追加する
     *
     * @param panel コンポーネントを追加するパネル
     * @return コンポーネントを追加したパネル
     */
    private JPanel addCenterComponent(JPanel panel) {
        // お預かりボタンを定義する
        JButton buttonDeposit = createTopButton(ButtonType.DEPOSIT.title);
        // お振込みボタンを定義する
        JButton buttonTransfer = createTopButton(ButtonType.TRANSFER.title);

        // パネルに上記コンポーネントを追加する
        panel.add(buttonDeposit);
        panel.add(buttonTransfer);

        return panel;
    }

    /**
     * 右用のコンポーネントを引数のパネルに追加する
     *
     * @param panel コンポーネントを追加するパネル
     * @return コンポーネントを追加したパネル
     */
    private JPanel addRightComponent(JPanel panel) {
        // 銀行名が書かれているラベルを定義する
        JLabel labelBankName = new JLabel("　" + Application.BANK_NAME);
        labelBankName.setFont(new Font("Serif", Font.BOLD, 42));
        // ATMのTOP画面に居そうな女性の画像ラベルを定義する
        JLabel labelWoman = new JLabel(new ImageIcon(TOP_WOMAN_PATH));

        // パネルに上記コンポーネントを追加する
        panel.add(labelBankName);
        panel.add(labelWoman);

        return panel;
    }

    /**
     * トップ画面に配置するボタンを生成する
     *
     * @param title ボタンのタイトル
     * @return トップ画面に配置するボタン
     */
    private JButton createTopButton(final String title) {
        JButton button = new JButton(title);
        // ボタンの文字のフォントを設定する
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        // ボタンを押した時の処理を設定する
        button.addActionListener(listener);
        button.setActionCommand(ButtonType.of(title).toString());

        return button;
    }

    /**
     * トップ画面を3分割した時のそれぞれの位置
     */
    private enum Position {
        LEFT,
        CENTER,
        RIGHT
    }

    /**
     * トップ画面のボタンの種類
     */
    public enum ButtonType {
        WITHDRAW("お引出し"),
        DEPOSIT("お預かり"),
        INQUIRY("残高照会"),
        TRANSFER("お振込み");

        private final String title;

        ButtonType(String title) {
            this.title = title;
        }

        public static ButtonType of(String title) {
            for (ButtonType type : ButtonType.values()) {
                // 引数とenum型の文字列部分を比較します。
                if (title.equals(type.title)) {
                    return type;
                }
            }
            return null;
        }
    }
}
