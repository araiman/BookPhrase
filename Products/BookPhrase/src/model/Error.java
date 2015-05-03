package model;

import java.io.Serializable;

/**
 * Created by RyomaArai on 15/05/03.
 */

// TODO 後々、エラーの幅がある程度決まってきた場合は、エラー番号を作成。switch_caseで、エラーメッセージを取り出すようにする。
public class Error implements Serializable {
    private String errorMsg;

    public Error() {

    }

    public Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
