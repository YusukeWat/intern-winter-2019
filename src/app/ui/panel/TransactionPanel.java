package app.ui.panel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 金額の取引を行う画面
 */
public class TransactionPanel extends NonTopPanel {

    public static final String TAG = TransactionPanel.class.getSimpleName();

    // ユーザ名を表示するラベル
    private JLabel mUsernameLabel;

    /**
     * コンストラクタ
     *
     * @param listener ボタン押下時に動作するActionLister
     */
    public TransactionPanel(ActionListener listener) {
        super(TAG, listener);
    }

    /**
     * 画面上部のコンポーネントを定義する
     */
    @Override
    protected void addConcreteComponent() {
        JLabel welcomeLabel = new JLabel("ようこそ");
        welcomeLabel.setBounds(250, 150, 60, 20);

        // usernameLabelだけメンバ変数...なぜ？
        //   -> 外からユーザ名文字列を受けて、表記を変更したいから
        mUsernameLabel = new JLabel("ユーザ名");
        mUsernameLabel.setBounds(340, 150, 120, 20);

        JLabel honorificLabel = new JLabel("様");
        honorificLabel.setBounds(480, 150, 30, 20);

        JLabel transactionLabel = new JLabel("お取引額");
        transactionLabel.setBounds(240, 250, 80, 20);

        JTextField transactionField = new JTextField(20);
        transactionField.setBounds(330, 245, 150, 30);

        JLabel unitLabel = new JLabel("円");
        unitLabel.setBounds(500, 250, 30, 20);

        add(welcomeLabel);
        add(mUsernameLabel);
        add(honorificLabel);
        add(transactionLabel);
        add(transactionField);
        add(unitLabel);
    }

    /**
     * 取引を行うユーザ名をセットする
     *
     * @param username 取引を行うユーザ名をセットする
     */
    public void setUsername(String username) {
        this.mUsernameLabel.setText(username);
    }
}
