package app.ui.simple;

import javax.swing.*;

abstract class SimpleWindow extends JFrame {

    // 子クラスで微妙に変えたい時のために、protectedで定義
    // ウィンドウの表示位置 x軸
    protected int x = 200;
    // ウィンドウの表示位置 y軸
    protected int y = 200;
    // ウィンドウの幅
    protected int width = 200;
    // ウィンドウの高さ
    protected int height = 100;

    public void init() {
        // ウィンドウの出る場所と大きさを設定する
        setBounds(x, y, width, height);
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
