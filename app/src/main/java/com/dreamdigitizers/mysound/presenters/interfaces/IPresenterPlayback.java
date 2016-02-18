package com.dreamdigitizers.mysound.presenters.interfaces;

import com.dreamdigitizers.androidbaselibrary.utilities.UtilsDialog;

public interface IPresenterPlayback extends IPresenterRx {
    void tracks(UtilsDialog.IRetryAction pRetryAction);
    void tracks(UtilsDialog.IRetryAction pRetryAction, int pLinkedPartitioning, int pLimit, int pOffset);
    void tracks(UtilsDialog.IRetryAction pRetryAction, int pLinkedPartitioning, int pLimit, int pOffset, String pQ);
    void userFavorites(UtilsDialog.IRetryAction pRetryAction);
    void userFavorites(UtilsDialog.IRetryAction pRetryAction, int pLinkedPartitioning, int pLimit, String pOffset);
    void playlists(int pId, UtilsDialog.IRetryAction pRetryAction);
    void playlist(int pId, UtilsDialog.IRetryAction pRetryAction);
}
