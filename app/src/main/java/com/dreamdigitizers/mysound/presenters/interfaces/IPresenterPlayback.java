package com.dreamdigitizers.mysound.presenters.interfaces;

import com.dreamdigitizers.androidbaselibrary.utilities.UtilsDialog;

public interface IPresenterPlayback extends IPresenterRx {
    void tracks(UtilsDialog.IRetryAction pRetryAction);
    void tracks(UtilsDialog.IRetryAction pRetryAction, int pLinkedPartitioning, int pOffset, int pLimit);
    void tracks(UtilsDialog.IRetryAction pRetryAction, int pLinkedPartitioning, int pOffset, int pLimit, String pQ);
    void userFavorites(int pId, UtilsDialog.IRetryAction pRetryAction);
    void playlists(int pId, UtilsDialog.IRetryAction pRetryAction);
    void playlist(int pId, UtilsDialog.IRetryAction pRetryAction);
}
