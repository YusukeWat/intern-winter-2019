package app.ui.panel;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AuthPanel extends NonTopPanel {

    public static final String TAG = AuthPanel.class.getSimpleName();

    private JTextField mUserField;
    private JTextField mPassField;

    /**
     * eclipseのswingデザインツールを使用して構築したので、座標直打ち
     * https://blog.goo.ne.jp/siyokuanjin/e/4c29a0e45c3890856175c76219ab2716
     */
    public AuthPanel(ActionListener listener) {
        super(TAG, listener);
    }

    /**
     * 画面上部のコンポーネントを定義する
     */
    @Override
    protected void addConcreteComponent() {
        JLabel userLabel = new JLabel("ご利用者名");
        userLabel.setBounds(250, 140, 80, 20);

        mUserField = new JTextField(20);
        mUserField.setBounds(350, 135, 200, 30);

        JLabel passLabel = new JLabel("パスワード");
        passLabel.setBounds(250, 200, 80, 20);

        mPassField = new JTextField(20);
        mPassField.setBounds(350, 195, 200, 30);

        add(userLabel);
        add(mUserField);
        add(passLabel);
        add(mPassField);
    }

    public String getUsername() {
        return mUserField.getText();
    }

    public String getPassword() {
        return mPassField.getText();
    }
}