package app.ui.panel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 金額の取引を行う画面
 */
public class TransactionPanel extends NonTopPanel {

    public static final String TAG = TransactionPanel.class.getSimpleName();

    // ユーザー名を表示するラベル
    private JLabel mUsernameLabel;
    // 取引額を入力するフィールド
    private JTextField mTransactionField;

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

        mUsernameLabel = new JLabel("ユーザー名");
        mUsernameLabel.setBounds(340, 150, 120, 20);

        JLabel honorificLabel = new JLabel("様");
        honorificLabel.setBounds(480, 150, 30, 20);

        JLabel transactionLabel = new JLabel("お取引額");
        transactionLabel.setBounds(240, 250, 80, 20);

        mTransactionField = new JTextField(20);
        mTransactionField.setBounds(330, 245, 150, 30);

        JLabel unitLabel = new JLabel("円");
        unitLabel.setBounds(500, 250, 30, 20);

        add(welcomeLabel);
        add(mUsernameLabel);
        add(honorificLabel);
        add(transactionLabel);
        add(mTransactionField);
        add(unitLabel);
    }

    @Override
    public void clear() {
        mUsernameLabel.setText("ユーザー名");
        mTransactionField.setText("");
    }

    /**
     * 取引を行うユーザー名を取得する
     *
     * @return 取引を行うユーザー名
     */
    public String getUsername() {
        return mUsernameLabel.getText();
    }

    /**
     * 取引を行うユーザー名をセットする
     *
     * @param username 取引を行うユーザー名をセットする
     */
    public void setUsername(String username) {
        this.mUsernameLabel.setText(username);
    }

    /**
     * 入力された取引額を取得する
     *
     * @return 入力された取引額
     */
    public int getInputAmount() {
        try {
            int input = Integer.parseInt(mTransactionField.getText());

            // 負の数だった場合は0とみなす
            if (input < 0) {
                return 0;
            }

            return input;

        } catch (NumberFormatException e) {
            // int型にキャストできなければ 0 とみなす
            return 0;
        }
    }
}
