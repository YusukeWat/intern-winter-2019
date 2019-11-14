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

    public MenuFrame(String title) {
        super(title);
        // メニューバーをフレームに設置する
        setJMenuBar(mMenuBar);
        // メニューバーに各メニューを追加する
        // 備忘録：keyの昇順にループが回る
        for (OriginalMenu menu : mMenuMap.values()) {
            mMenuBar.add(menu);
        }
    }

    public OriginalMenu getMenu(String key) {
        return mMenuMap.get(key);
    }
}
