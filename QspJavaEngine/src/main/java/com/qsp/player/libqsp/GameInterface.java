package com.qsp.player.libqsp;

import com.qsp.player.core.model.RefreshInterfaceRequest;
import com.qsp.player.core.model.WindowType;

public interface GameInterface {

    void refresh(RefreshInterfaceRequest request);

    void showError(String message);
    void showPicture(String path);
    void showMessage(String message);
    String showInputBox(String prompt);
    int showMenu();
    void saveGame(String filename);
    String loadSaveGame(String filename);
     void deleteSaveGame(String filename);
    void showWindow(WindowType type, boolean show);


    void setCounterInterval(int millis);


    void doWithCounterDisabled(Runnable runnable);
}
