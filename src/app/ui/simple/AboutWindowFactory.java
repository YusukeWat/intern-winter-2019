package app.ui.simple;

public class AboutWindowFactory implements WindowFactory {

    private static final SimpleWindow INSTANCE = new AboutWindow();

    @Override
    public SimpleWindow getWindow() {
        return INSTANCE;
    }
}
