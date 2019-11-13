import javax.swing.*;
import java.awt.*;

/**
 * aboutウィンドウの制御クラス
 * アイテムの連続クリックによる複数展開を防ぐため、シングルインスタンスで管理する
 */
class AboutWindowController {
    /** aboutウィンドウ */
    private static JFrame aboutWindow;

    static {
        aboutWindow = new JFrame();
        aboutWindow.setBounds(200, 200, 200, 100);
        aboutWindow.setResizable(false);
        // aboutWindowは可視性によって表示を制御するので、×が押されたら表示を隠すだけ
        aboutWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel label = new JLabel(String.format("アプリのバージョン：%s", Sample.APP_VERSION));
        aboutWindow.getContentPane().add(label, BorderLayout.CENTER);
    }

    /**
     * aboutウィンドウを表示する
     */
    public static void show() {
        aboutWindow.setVisible(true);
    }
}
