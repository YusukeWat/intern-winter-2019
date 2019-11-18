package app.ui;

import app.App;

import javax.swing.*;
import java.awt.*;

public class AtmTopPanel extends JPanel {
    private static final String DRAW_TITLE = "お引出し";
    private static final String DEPOSIT_TITLE = "お預かり";
    private static final String INQUIRY_TITLE = "残高照会";
    private static final String TRANSFER_TITLE = "お振込み";
    private static final String TOP_WOMAN_PATH = "./res/image/top_woman.png";

    public AtmTopPanel() {
        // このパネル自体のレイアウトを設定する
        // 画面を 左、中央、右 に3分割する
        setLayout(new GridLayout(1, 3));
        // 左、中央、右の順に用意しているパネルを追加する
        add(getPanelOf(Position.LEFT));
        add(getPanelOf(Position.CENTER));
        add(getPanelOf(Position.RIGHT));
    }

    private JPanel getPanelOf(Position position) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        switch (position) {
            case LEFT:
                panel = addLeftComponent(panel);
                break;
            case CENTER:
                panel = addCenterComponent(panel);
                break;
            case RIGHT:
                panel = addRightComponent(panel);
                break;
        }

        return panel;
    }

    private JPanel addLeftComponent(JPanel panel) {
        // お引出しボタンを定義する
        JButton buttonDraw = createTopButton(DRAW_TITLE);
        // 残高照会ボタンを定義する
        JButton buttonInquiry = createTopButton(INQUIRY_TITLE);

        // パネルに上記コンポーネントを追加する
        panel.add(buttonDraw);
        panel.add(buttonInquiry);

        return panel;
    }

    private JPanel addCenterComponent(JPanel panel) {
        // お預かりボタンを定義する
        JButton buttonDeposit = createTopButton(DEPOSIT_TITLE);
        // お振込みボタンを定義する
        JButton buttonTransfer = createTopButton(TRANSFER_TITLE);

        // パネルに上記コンポーネントを追加する
        panel.add(buttonDeposit);
        panel.add(buttonTransfer);

        return panel;
    }

    private JPanel addRightComponent(JPanel panel) {
        // 銀行名が書かれているラベルを定義する
        JLabel labelBankName = new JLabel("　" + App.BANK_NAME);
        labelBankName.setFont(new Font("Serif", Font.BOLD, 42));
        // ATMのTOP画面に居そうな女性の画像ラベルを定義する
        JLabel labelWoman = new JLabel(new ImageIcon(TOP_WOMAN_PATH));

        // パネルに上記コンポーネントを追加する
        panel.add(labelBankName);
        panel.add(labelWoman);

        return panel;
    }

    private JButton createTopButton(String title) {
        JButton button = new JButton(title);
        // ボタンの文字のフォントを設定する
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        // ボタンを押した時の処理を設定する
        button.addActionListener(actionEvent -> {
            // TODO 認証画面に遷移する処理を書く
        });

        return button;
    }

    private enum Position {
        LEFT,
        CENTER,
        RIGHT;
    }
}
