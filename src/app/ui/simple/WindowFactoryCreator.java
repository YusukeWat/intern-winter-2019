package app.ui.simple;

/**
 * シンプルなウィンドウを取得するためのFactoryクラスを生成するクラス
 * <p>
 * 各ウィンドウはこのプログラム上でインスタンスを1つだけしか持たないようにしたかった
 * そのため、各ウィンドウのFactoryクラスでインスタンスを1個だけ持つように作った
 */
public class WindowFactoryCreator {

    /**
     * 引数に指定する文字列に応じたWindowFactoryクラスを取得する
     * - "about"       : AboutWindowのFactoryクラス
     * - "authfail"    : AuthFailWindowのFactoryクラス
     * - "close"       : CloseWindowのFactoryクラス
     * - "construction": ConstructionWindowのFactoryクラス
     *
     * @param type 取得したいWindowFactoryクラスの種類
     * @return 引数文字列に応じたWindowFactoryクラス。無効な文字列を指定するとnullが返る
     */
    public static WindowFactory createFactoryOf(String type) {
        switch (type) {
            case "about":
                return new AboutWindowFactory();
            case "authfail":
                return new AuthFailWindowFactory();
            case "close":
                return new CloseWindowFactory();
            case "construction":
                return new ConstructionWindowFactory();
            default:
                return null;
        }
    }
}
