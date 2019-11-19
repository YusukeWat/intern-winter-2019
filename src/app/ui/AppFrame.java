package app.ui;

import app.Application;
import app.ui.menu.MenuFrame;
import app.ui.simple.WindowFactoryCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static app.ui.TopPanel.ButtonType;

// アプリの屋台骨となるJFrame拡張クラス
// 1枚パネルを置いとくだけ
// パネルの差し替えで画面遷移を実現する
public class AppFrame extends MenuFrame implements ActionListener {

    private JPanel mainPanel = new JPanel();
    private CardLayout layout = new CardLayout();

    public AppFrame() {
        setTitle(Application.NAME);
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initMainPanel();
        add(mainPanel);
    }

    private void initMainPanel() {
        // メインのパネルにレイアウトを登録
        mainPanel.setLayout(layout);

        // 表示する画面のパネルを定義
        // トップ
        TopPanel topPanel = new TopPanel(this);
        // 認証
        AuthPanel authPanel = new AuthPanel(this);

        // メインパネルに各画面パネルを追加
        mainPanel.add(topPanel, TopPanel.TAG);
        mainPanel.add(authPanel, AuthPanel.TAG);
        layout.show(mainPanel, TopPanel.TAG);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final String e = actionEvent.getActionCommand();

        // 画面遷移(仮)
        if (e.equals(ButtonType.WITHDRAW.toString())) {
            layout.show(mainPanel, AuthPanel.TAG);
        } else if (e.equals(AuthPanel.TAG + ".positive")) {
            WindowFactoryCreator.createFactoryOf("close").getWindow().display();
        } else if (e.equals(AuthPanel.TAG + ".negative")) {
            layout.show(mainPanel, TopPanel.TAG);
        } else {
//            WindowFactoryCreator.createFactoryOf("about").getWindow().display();
        }
    }
}
