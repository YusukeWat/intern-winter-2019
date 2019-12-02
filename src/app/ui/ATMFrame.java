package app.ui;

import app.ATMActionType;
import app.AccountManager;
import app.Application;
import app.ui.menu.MenuFrame;
import app.ui.panel.AuthPanel;
import app.ui.panel.NonTopPanel;
import app.ui.panel.TopPanel;
import app.ui.panel.TransactionPanel;
import app.ui.simple.TransactionWindow;
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

    private JPanel mMainPanel;
    private CardLayout mLayout;

    private AuthPanel mAuthPanel;
    private TransactionPanel mTransactionPanel;

    private AccountManager mAccountManager;

    public ATMFrame() {
        setTitle(Application.NAME);
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mMainPanel = new JPanel();
        initMainPanel();
        add(mMainPanel);

        mAccountManager = new AccountManager();
    }

    /**
     * メインのパネルを設定する
     */
    private void initMainPanel() {
        // メインのパネルにレイアウトを登録
        mLayout = new CardLayout();
        mMainPanel.setLayout(mLayout);

        ActionListenerRelay actionListenerRelay = new ActionListenerRelay(this);

        // 表示する画面のパネルを定義
        // トップ画面
        TopPanel topPanel = new TopPanel(actionListenerRelay);
        // 認証画面
        mAuthPanel = new AuthPanel(actionListenerRelay);
        // 取引画面
        mTransactionPanel = new TransactionPanel(actionListenerRelay);

        // メインパネルに各画面パネルを追加
        mMainPanel.add(topPanel, TopPanel.TAG);
        mMainPanel.add(mAuthPanel, AuthPanel.TAG);
        mMainPanel.add(mTransactionPanel, TransactionPanel.TAG);
        // トップ画面を表示
        mLayout.show(mMainPanel, TopPanel.TAG);
    }

    /**
     * ボタンが押されたときの情報を保持した上で通知される関数
     * ボタンを押した状況によった処理を行う
     *
     * @param actionPanelTag 押されたボタンが配置されているパネル
     *                       各画面のTAG文字列が入っている
     * @param actionType     ボタンが押されたときのATMアクションの種類
     *                       ATMActionTypeのいずれかが入っている
     * @param buttonType     押されたボタンの種類
     *                       以下いずれかが入っている
     *                       NonTopPanel.NEGATIVE_BUTTON_TAG ( = ".negative") -> 取消ボタン
     *                       NonTopPanel.POSITIVE_BUTTON_TAG ( = ".positive") -> 確定ボタン
     */
    @Override
    public void onATMAction(String actionPanelTag, ATMActionType actionType, String buttonType) {
        switch (buttonType) {
            // ↓↓↓↓ トップ画面のボタンを押したときの処理 ↓↓↓↓
            case TopPanel.BUTTON_TAG:
                processTopPanel(actionType);
                break;

            // ↓↓↓↓ 非トップ画面で取消ボタンを押したときの処理 ↓↓↓↓
            case NonTopPanel.NEGATIVE_BUTTON_TAG:
                backTopPanel();
                break;

            // ↓↓↓↓ 非トップ画面で確定ボタンを押したときの処理 ↓↓↓↓
            case NonTopPanel.POSITIVE_BUTTON_TAG:
                // ↓↓↓↓↓↓↓↓ 確定ボタンを押したのが 認証画面 だったときの処理 ↓↓↓↓↓↓↓↓
                if (actionPanelTag.equals(AuthPanel.TAG)) {
                    auth();

                // ↓↓↓↓↓↓↓↓ 確定ボタンを押したのが 取引画面 だったときの処理 ↓↓↓↓↓↓↓↓
                } else if (actionPanelTag.equals(TransactionPanel.TAG)) {
                    transact(actionType);
                }

                break;
        }
    }

    /**
     * トップ画面のボタンに応じた処理を行う
     *
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

    /**
     * 認証を行う
     * 成功したら、取引画面へ遷移する
     * 失敗したら、トップ画面へ戻る
     */
    private void auth() {
        // 認証画面で入力された情報を取得する
        String username = mAuthPanel.getUsername();
        String password = mAuthPanel.getPassword();

        // 認証を行う
        if (mAccountManager.auth(username, password)) {
            // 認証に成功したユーザー名を取引画面に設定してから取引画面へ遷移する
            mTransactionPanel.setUsername(username);
            mLayout.show(mMainPanel, TransactionPanel.TAG);
        } else {
            // 認証失敗のウィンドウを表示して、トップ画面に戻る
            WindowFactoryCreator.createFactoryOf("authfail").getWindow().display();
            backTopPanel();
        }
    }

    /**
     * 取引を行い、結果を別ウィンドウで表示する
     * 完了後、トップ画面に戻る
     *
     * @param actionType ボタンが押されたときのATMアクションの種類
     */
    private void transact(ATMActionType actionType) {
        // 取引画面で入力された情報などを取得する
        String username = mTransactionPanel.getUsername();
        int transactionAmount = mTransactionPanel.getInputAmount();

        // 入力情報を元にお金を取引する
        int afterAmount = mAccountManager.transact(username, transactionAmount, actionType);

        // 取引結果を表示するウィンドウを準備する
        TransactionWindow window = TransactionWindow.getInstance();
        // transact関数の戻り値が -1 でないかチェックする
        // -1 でなければ、取引は成功したということ
        if (afterAmount > 0) {
            mAccountManager.save();
            window.setAmount(afterAmount);
        } else {
            window.setTransactionFailure();
        }
        window.display();

        backTopPanel();
    }

    /**
     * トップ画面に戻る
     */
    private void backTopPanel() {
        mLayout.show(mMainPanel, TopPanel.TAG);

        //トップ画面に戻った後、入力情報をクリアする
        mAuthPanel.clear();
        mTransactionPanel.clear();
    }
}
