package app.ui.simple;

public class ConstructionWindowFactory implements WindowFactory {

    private static final SimpleWindow INSTANCE = new ConstructionWindow();

    @Override
    public SimpleWindow getWindow() {
        return INSTANCE;
    }
}
