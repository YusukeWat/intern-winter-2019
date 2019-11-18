package app.ui.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuFrame extends JFrame {

    private final JMenuBar mMenuBar = new JMenuBar();

    private final Map<String, OriginalMenu> mMenuMap = new LinkedHashMap<>() {
        {
            put(FileMenu.TITLE, new FileMenu());
            put(HelpMenu.TITLE, new HelpMenu());
        }
    };

    public MenuFrame() {
        // メニューバーをフレームに設置する
        setJMenuBar(mMenuBar);
        // メニューバーに各メニューを追加する
        for (OriginalMenu menu : mMenuMap.values()) {
            mMenuBar.add(menu);
        }
    }

    public final OriginalMenu getMenu(String key) {
        return mMenuMap.get(key);
    }
}
