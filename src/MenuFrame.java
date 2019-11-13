import javax.swing.*;

class MenuFrame extends JFrame {

    protected final JMenuBar bar = new JMenuBar();
    protected final JMenu menuHelp = new JMenu("ヘルプ");
    protected final JMenuItem itemAbout = new JMenuItem(String.format("%s について", Sample.APP_NAME));

    public MenuFrame() {
        this("");
    }

    public MenuFrame(String title) {
        super(title);
        setJMenuBar(bar);
        setupMenuHelp();
    }

    /**
     * メニュー「ヘルプ」の設定をする
     */
    private void setupMenuHelp() {
        itemAbout.addActionListener(actionEvent ->
            AboutWindowController.show()
        );
        menuHelp.add(itemAbout);
        bar.add(menuHelp);
    }
}
