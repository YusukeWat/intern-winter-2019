package app.ui.simple;

/**
 * シンプルなウィンドウの管理クラス
 */
public class SimpleWindowManager {

    /**
     * 指定したタイプのウィンドウを表示する
     *
     * @param type ウィンドウのタイプ
     */
    public void displayOf(WindowType type) {
        type.instance.display();
    }

    /**
     * シンプルなウィンドウの一覧を表す列挙型
     * ユーザはここから使用したいウィンドウのタイプを選択する
     */
    public enum WindowType {
        ABOUT(new AboutWindow()),
        CLOSE(new CloseWindow());

        private SimpleWindow instance;

        WindowType(SimpleWindow instance) {
            this.instance = instance;
            this.instance.init();
        }
    }
}
