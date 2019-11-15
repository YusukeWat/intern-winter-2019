package app.ui.menu;

import app.App;
import app.ui.simple.WindowFactory;
import app.ui.simple.WindowFactoryCreator;

/**
 * 「ファイル」メニュー
 */
public class FileMenu extends OriginalMenu {

    public static final String TITLE = "ファイル";

    public FileMenu() {
        super(TITLE);
    }

    @Override
    public void setupInternal() {
        // 「アプリ を終了する」アイテムを登録する
        registerItem(Item.CLOSE.getKey(), Item.CLOSE.getTitle(), actionEvent -> {
            // アプリを終了するか聞くだけのシンプルなウィンドウを表示する
            WindowFactory factory = WindowFactoryCreator.createFactoryOf("close");
            factory.getWindow().display();
        });
    }

    /**
     * メニューが保持するアイテムの一覧
     */
    public enum Item {
        CLOSE("item_close", String.format("%s を終了する", App.APP_NAME));

        private String key;
        private String title;

        Item(String key, String title) {
            this.key = key;
            this.title = title;
        }

        /**
         * アイテムのキー値を取得する
         * @return キー値
         */
        public String getKey() {
            return key;
        }

        private String getTitle() {
            return title;
        }
    }
}
