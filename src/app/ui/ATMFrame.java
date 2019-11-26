package app.ui;

import app.ATMActionType;
import app.Application;
import app.ui.menu.MenuFrame;
import app.ui.panel.AuthPanel;
import app.ui.panel.NonTopPanel;
import app.ui.panel.TopPanel;
import app.ui.panel.TransactionPanel;
import app.ui.simple.WindowFactoryCreator;

import javax.swing.*;
import java.awt.*;

/**
 * アプリの屋台骨となるJFrame拡張クラス
 * 1枚パネルを置いとくだけ
 * このパネルに画面パネルを逐次貼り付けることで、画面遷移を実現する
 */
public class ATMFrame extends MenuFrame implements ActionListenerRelay.ATMActionListener {

    public static final Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 36);

    private JPanel mMainPanel = new JPanel();
    private CardLayout mLayout = new CardLayout();

    private AuthPanel authPanel;
    private TransactionPanel transactionPanel;

    public ATMFrame() {
        setTitle(Application.NAME);
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initMainPanel();
        add(mMainPanel);
    }

    /**
     *
     */
    private void initMainPanel() {
        // メインのパネルにレイアウトを登録
        mMainPanel.setLayout(mLayout);

        ActionListenerRelay actionListenerRelay = new ActionListenerRelay(this);

        // 表示する画面のパネルを定義
        // トップ画面
        TopPanel topPanel = new TopPanel(actionListenerRelay);
        // 認証画面
        authPanel = new AuthPanel(actionListenerRelay);
        // 取引画面
        transactionPanel = new TransactionPanel(actionListenerRelay);

        // メインパネルに各画面パネルを追加
        mMainPanel.add(topPanel, TopPanel.TAG);
        mMainPanel.add(authPanel, AuthPanel.TAG);
        mMainPanel.add(transactionPanel, TransactionPanel.TAG);
        // トップ画面を表示
        mLayout.show(mMainPanel, TopPanel.TAG);
    }

    @Override
    public void onATMAction(String actionPanelTag, ATMActionType actionType, String buttonType) {
        switch (buttonType) {
            case TopPanel.BUTTON_TAG:
                processTopPanel(actionType);
                break;
            case NonTopPanel.NEGATIVE_BUTTON_TAG:
                mLayout.show(mMainPanel, TopPanel.TAG);
                break;
            case NonTopPanel.POSITIVE_BUTTON_TAG:
                if (actionPanelTag.equals(AuthPanel.TAG)) {
                    transactionPanel.setUsername(authPanel.getUsername());
                    mLayout.show(mMainPanel, TransactionPanel.TAG);
                } else {
                    mLayout.show(mMainPanel, TopPanel.TAG);
                }
                break;
        }
    }

    /**
     * トップ画面のボタンに応じた処理を行う
     * @param actionType ATMアクションの種類
     */
    private void processTopPanel(ATMActionType actionType) {
        switch (actionType) {
            case WITHDRAW:
            case DEPOSIT:
                mLayout.show(mMainPanel, AuthPanel.TAG);
                break;
            case INQUIRY:
            case TRANSFER:
                WindowFactoryCreator.createFactoryOf("construction").getWindow().display();
                break;
        }
    }
}
