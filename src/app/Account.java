package app;

/**
 * アカウントのデータクラス
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private int amount;

    public Account() {
    }

    public Account(int id, String username, String password, int amount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    /**
     * 配列をそのまま受け取ってセットする用
     * 1個ずつセットするのが面倒だったのでこのsetterを作った
     *
     * @param array String.split(",") で区切ったString配列
     */
    public void setAllBySplitData(String[] array) {
        if (array.length < 4) {
            return;
        }

        this.id = Integer.parseInt(array[0]);
        this.username = array[1];
        this.password = array[2];
        this.amount = Integer.parseInt(array[3]);
    }

    /**
     * IDを取得する
     *
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * ユーザー名を取得する
     *
     * @return ユーザー名
     */
    public String getUsername() {
        return username;
    }

    /**
     * パスワードを取得する
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * 残高を取得する
     *
     * @return 残高
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 残高にお金を追加する
     *
     * @param amount 追加金額
     * @return 追加後の残高
     */
    public int addAmount(int amount) {
        this.amount += amount;

        return this.amount;
    }

    /**
     * 残高からお金を抜く
     *
     * @param amount 抜く金額
     * @return 抜いた後の残高
     * @throws IllegalArgumentException 抜いた後に残高がマイナスになってしまう場合
     */
    public int decreasesAmount(int amount) throws IllegalArgumentException {
        if (this.amount < amount) {
            throw new IllegalArgumentException();
        }

        this.amount -= amount;

        return this.amount;
    }
}
