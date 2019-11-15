package app.ui.simple;

public class CloseWindowFactory implements WindowFactory {

    private static final SimpleWindow INSTANCE = new CloseWindow();

    @Override
    public SimpleWindow getWindow() {
        return INSTANCE;
    }
}
