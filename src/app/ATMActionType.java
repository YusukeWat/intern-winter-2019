package app;

/**
 * ATMの行動の種類
 */
public enum ATMActionType {
    WITHDRAW("お引出し"),
    DEPOSIT("お預かり"),
    INQUIRY("残高照会"),
    TRANSFER("お振込み");

    private final String buttonTitle;

    ATMActionType(String title) {
        this.buttonTitle = title;
    }

    /**
     * ボタンのタイトル文字列に対応するATMアクションの種類を返す
     * 文字列が無効な場合、nullを返す
     *
     * @param buttonTitle ボタンのタイトル文字列
     * @return ATMアクションの種類
     */
    public static ATMActionType of(String buttonTitle) {
        for (ATMActionType type : ATMActionType.values()) {
            // 引数とenum型の文字列部分を比較します。
            if (buttonTitle.equals(type.buttonTitle)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 行動選択のボタンにつけるタイトル文字列を取得する
     *
     * @return
     */
    public String getButtonTitle() {
        return buttonTitle;
    }
}
