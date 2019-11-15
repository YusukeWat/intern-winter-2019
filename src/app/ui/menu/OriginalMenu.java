package app.ui.menu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * JMenuクラスに、配置するアイテムの情報を持たせたクラス
 */
public abstract class OriginalMenu extends JMenu {

    private final Map<String, JMenuItem> mItemMap = new HashMap<>();

    public OriginalMenu(String title) {
        super(title);
        setupInternal();
    }

    protected abstract void setupInternal();

    protected JMenuItem registerItem(String itemKey, String title, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(title);
        item.addActionListener(actionListener);
        add(item);
        putItem(itemKey, item);

        return item;
    }

    private void putItem(String key, JMenuItem item) {
        mItemMap.put(key, item);
    }

    public void setEnabledOf(String itemKey, boolean enabled) {
        mItemMap.get(itemKey).setEnabled(enabled);
    }

    public boolean isEnabledOf(String itemKey) {
        return mItemMap.get(itemKey).isEnabled();
    }
}
