package app.ui.simple;

import javax.swing.*;

/**
 * シンプルな項目を表示するウィンドウの基底クラス
 * 抽象化したい処理はコンポーネント追加のみなので、抽象クラスで定義
 */
public abstract class SimpleWindow extends JFrame {

    /**
     * コンストラクタ
     * ウィンドウ共通の設定をする
     */
    SimpleWindow() {
        // ウィンドウの出る場所と大きさを設定する
        setBounds(200, 200, 200, 100);
        // ドラッグで画面を引き延ばせないようにする
        setResizable(false);
        // ×が押されたら表示を隠す
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        addComponent();
    }

    /**
     * ウィンドウにコンポーネントを追加する抽象メソッド
     * 継承先によって追加するコンポーネントが異なるため抽象化する
     */
    protected abstract void addComponent();

    /**
     * ウィンドウを表示する
     */
    public void display() {
        setVisible(true);
    }
}
