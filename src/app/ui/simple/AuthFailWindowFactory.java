package app.ui.simple;

public class AuthFailWindowFactory implements WindowFactory {

    private static final SimpleWindow INSTANCE = new AuthFailWindow();

    @Override
    public SimpleWindow getWindow() {
        return INSTANCE;
    }
}