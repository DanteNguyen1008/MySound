package com.dreamdigitizers.mysound.presenters.interfaces;

import com.dreamdigitizers.androidbaselibrary.presenters.interfaces.IPresenterBase;

public interface IPresenterLogin extends IPresenterBase {
    void saveAccessToken(String pAccessToken);
}
