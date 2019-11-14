package app.ui.menu;

import app.App;
import app.ui.simple.SimpleWindowManager;

public class HelpMenu extends OriginalMenu {

    public static final String TITLE = "ヘルプ";

    public HelpMenu() {
        super(TITLE);
    }

    @Override
    public void setupInternal() {
        // 「アプリ について」アイテムを登録する
        registerItem(Item.ABOUT.getKey(), Item.ABOUT.getTitle(), actionEvent ->
                // アプリバージョンを表示するだけのシンプルなウィンドウを表示する
                new SimpleWindowManager().displayOf(SimpleWindowManager.WindowType.ABOUT)
        );
    }

    public enum Item {
        ABOUT("item_about", String.format("%s について", App.APP_NAME));

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
