package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * アカウント情報を管理するクラス
 */
public class AccountManager {

    private static final String ACCOUNT_FILE_PATH = "./res/csv/account.csv";

    private List<Account> mAccountList;

    public AccountManager() {
        mAccountList = new ArrayList<>();
        initAccountList();
    }

    /**
     * csvファイルの情報をメモリに保持する
     */
    private void initAccountList() {
        try {
            FileInputStream fileInputStream = new FileInputStream(ACCOUNT_FILE_PATH);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

            // 先頭行かどうかを判断するフラグ
            boolean isFirstLine = true;
            // 読み込み行
            String line;
            // 1行ずつ読み込みを行う、読み込み行がなくなるまでループ
            while ((line = bufferReader.readLine()) != null) {
                // 先頭行は列名なので、データ保持しない
                // 2行目以降からメモリ保持を行う
                if (!isFirstLine) {
                    // カンマで分割した内容を配列に格納する
                    String[] splitData = line.split(",");
                    // 配列をデータクラスに変換する
                    Account account = new Account();
                    account.setAllBySplitData(splitData);

                    mAccountList.add(account);
                }
                //行数のインクリメント
                isFirstLine = false;

            }
            bufferReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * ユーザー名とパスワードで認証する
     *
     * @param username ユーザ名
     * @param password パスワード
     * @return 認証の成功／失敗
     */
    public boolean auth(String username, String password) {
        for (Account account : mAccountList) {
            // ユーザー名が一致するアカウントでなければ次のアカウントへ飛ぶ
            if (!username.equals(account.getUsername())) {
                continue;
            }
            // さらにパスワードも一致してなければ次のアカウントへ飛ぶ
            if (!password.equals(account.getPassword())) {
                continue;
            }
            // 一致しているアカウントがあればtrueを返す
            return true;
        }
        // trueを返さないままループが終わる = 認証失敗
        return false;
    }

    /**
     * 指定したユーザーの口座と取引する
     *
     * @param username ユーザー名
     * @param transactionAmount 取引額
     * @return 取引後の残高
     *         以下に該当する場合は -1 を返却する
     *          - 指定したユーザーが無効の場合
     *          - アクションの種類がWITHDRAWかDEPOSITでなかった場合
     *          - 引出し額が残高よりも多い場合
     */
    public int transact(String username, int transactionAmount, ATMActionType actionType) {
        int after = -1;

        for (Account account : mAccountList) {
            // ユーザー名が引数と一致していなければスキップ
            if (!username.equals(account.getUsername())) {
                continue;
            }

            // 引数のアクションタイプによって処理を変える
            switch (actionType) {
                case WITHDRAW:
                    after = account.decreasesAmount(transactionAmount);
                    break;
                case DEPOSIT:
                    after = account.addAmount(transactionAmount);
                    break;
            }
        }

        return after;
    }

    /**
     * 現在のアカウント情報をファイルに記録する
     */
    public void save() {
        try {
            FileWriter fileWriter = new FileWriter(ACCOUNT_FILE_PATH, false);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));

            // 1行目
            StringBuilder sb = new StringBuilder();
            sb.append("id").append(",").append("username").append(",").append("password").append(",").append("amount");
            printWriter.print(sb.toString());
            printWriter.println();

            // 2行目以降
            for (Account account : mAccountList) {
                printWriter.print(account.getId());
                printWriter.print(",");
                printWriter.print(account.getUsername());
                printWriter.print(",");
                printWriter.print(account.getPassword());
                printWriter.print(",");
                printWriter.print(account.getAmount());
                printWriter.println();
            }

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
