package app.ui;

import app.ATMActionType;
import app.ui.panel.AuthPanel;
import app.ui.panel.TopPanel;
import app.ui.panel.TransactionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListenerの中継クラス
 * ActionListenerで取得した情報をわかりやすい形に変形して上位に通知する
 */
public class ActionListenerRelay implements ActionListener {

    private ATMActionListener mListener;
    // トップ以外の画面で押されたとき、
    // どのATMアクションでの行動かを覚えておくためにメンバ変数で状態保持
    private ATMActionType mActionType = null;

    public ActionListenerRelay(ATMActionListener listener) {
        this.mListener = listener;
    }

    /**
     * ボタンが押された時に呼び出される関数
     * ここでアクション識別子を使ってどの画面のどのボタンが押されたかを判定し、
     * 登録されているATMActionListener.onATMActionを呼ぶ
     *
     * @param actionEvent ボタンが押されたときの情報
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // 押されたボタンのアクション識別子を取得する
        final String actionCommand = actionEvent.getActionCommand();

        String actionPanelTag = null;
        String buttonType = null;

        // どの画面での動作だったかを確認する
        // トップ画面だったか？
        if (actionCommand.contains(TopPanel.TAG)) {
            actionPanelTag = TopPanel.TAG;
            // 画面情報を抜き取って、アクションの種類だけの文字列にする
            String actionTypeStr = actionCommand.substring(actionPanelTag.length());
            // アクションの種類だけの文字列をきちんとした型に直して、保存する
            mActionType = ATMActionType.valueOf(actionTypeStr);
            buttonType = TopPanel.BUTTON_TAG;

        } else if (actionCommand.contains(AuthPanel.TAG)) {
            actionPanelTag = AuthPanel.TAG;
            // 画面情報を抜き取って、ボタンの種類だけの文字列にする
            buttonType = actionCommand.substring(actionPanelTag.length());

        } else if (actionCommand.contains(TransactionPanel.TAG)) {
            actionPanelTag = TransactionPanel.TAG;
            // 画面情報を抜き取って、ボタンの種類だけの文字列にする
            buttonType = actionCommand.substring(actionPanelTag.length());
        }

        // 判定した情報を通知する
        callbackATMActionListener(actionPanelTag, mActionType, buttonType);
    }

    /**
     * ATMActionListener.onATMActionをコールバックする
     *
     * @param actionPanelTag 押されたボタンが配置されているパネル
     * @param actionType     ATMアクションの種類
     * @param buttonType     押されたボタンの種類
     */
    private void callbackATMActionListener(String actionPanelTag, ATMActionType actionType, String buttonType) {
        if (mListener == null) {
            return;
        }

        if (actionPanelTag == null || actionType == null || buttonType == null) {
            return;
        }

        mListener.onATMAction(actionPanelTag, actionType, buttonType);
    }

    /**
     * ボタンが押されたときの状態を通知するリスナーインターフェース
     */
    public interface ATMActionListener {
        /**
         * ボタンが押されたときの状態を通知する
         *
         * @param actionPanelTag 押されたボタンが配置されているパネル
         *                       各画面のTAG文字列が入っている
         *
         * @param actionType     ボタンが押されたときのATMアクションの種類
         *                       ATMActionTypeのいずれかが入っている
         *
         * @param buttonType     押されたボタンの種類
         *                       以下いずれかが入っている
         *                       NonTopPanel.NEGATIVE_BUTTON_TAG ( = ".negative") -> 取消ボタン
         *                       NonTopPanel.POSITIVE_BUTTON_TAG ( = ".positive") -> 確定ボタン
         *                       TopPanel.BUTTON_TAG ( = ".top") -> トップ画面のボタン
         */
        void onATMAction(String actionPanelTag, ATMActionType actionType, String buttonType);
    }
}
