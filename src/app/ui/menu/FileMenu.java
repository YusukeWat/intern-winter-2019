package app.ui.menu;

import app.App;
import app.ui.simple.SimpleWindowManager;

public class FileMenu extends OriginalMenu {

    public static final String TITLE = "ファイル";

    public FileMenu() {
        super(TITLE);
    }

    @Override
    public void setupInternal() {
        // 「アプリ を終了する」アイテムを登録する
        registerItem(Item.CLOSE.getKey(), Item.CLOSE.getTitle(), actionEvent ->
                // アプリを終了するか聞くだけのシンプルなウィンドウを表示する
                new SimpleWindowManager().displayOf(SimpleWindowManager.WindowType.CLOSE)
        );
    }

    public enum Item {
        CLOSE("item_close", String.format("%s を終了する", App.APP_NAME));

        private String key;
        private String title;

        Item(String key, String title) {
            this.key = key;
            this.title = title;
        }

        public String getKey() {
            return key;
        }

        private String getTitle() {
            return title;
        }
    }
}
