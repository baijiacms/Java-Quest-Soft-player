package com.qsp.javafx;

import com.qsp.player.core.QspViewInterface;

public class CommonViewImpl implements QspViewInterface {
    /**
     * 消息输入
     * @param prompt
     * @return
     */
    @Override
    public String getInputStr(String prompt) {
        return JavaFxUtils.showTextInputDialog(prompt);
    }

    /**
     * 消息提示框
     * @param prompt
     */
    @Override
    public void showMessageBox(String prompt) {
        JavaFxUtils.showAlertDialog(prompt);
    }
    @Override
    public void showErrorBox(String prompt) {
        JavaFxUtils.showErrorialog(prompt);
    }

    @Override
    public void showPicture(String imagePath) {

    }
}

