package app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthPanel extends JPanel {

    public static final String TAG = AuthPanel.class.getSimpleName();

    /**
     * eclipseのswingデザインツールを使用して構築したので、座標直打ち
     * https://blog.goo.ne.jp/siyokuanjin/e/4c29a0e45c3890856175c76219ab2716
     */
    public AuthPanel(ActionListener listener) {
        setLayout(null);

        JLabel userLabel = new JLabel("ご利用者名");
        userLabel.setBounds(250, 140, 80, 20);

        JTextField userField = new JTextField(20);
        userField.setBounds(350, 135, 200, 30);

        JLabel passLabel = new JLabel("パスワード");
        passLabel.setBounds(250, 200, 80, 20);

        JTextField passField = new JTextField(20);
        passField.setBounds(350, 195, 200, 30);

        JButton negativeButton = new JButton("取消");
        negativeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 36));
        negativeButton.setBounds(50, 420, 200, 100);
        negativeButton.addActionListener(listener);
        negativeButton.setActionCommand(AuthPanel.TAG + ".negative");

        JButton positiveButton = new JButton("確定");
        positiveButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 36));
        positiveButton.setBounds(550, 420, 200, 100);
        positiveButton.addActionListener(listener);
        positiveButton.setActionCommand(AuthPanel.TAG + ".positive");

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(negativeButton);
        add(positiveButton);
    }
}
