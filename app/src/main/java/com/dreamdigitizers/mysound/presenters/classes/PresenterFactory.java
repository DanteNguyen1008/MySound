package com.dreamdigitizers.mysound.presenters.classes;

import com.dreamdigitizers.androidbaselibrary.presenters.interfaces.IPresenterBase;
import com.dreamdigitizers.androidbaselibrary.views.interfaces.IViewBase;
import com.dreamdigitizers.mysound.presenters.interfaces.IPresenterHome;
import com.dreamdigitizers.mysound.presenters.interfaces.IPresenterLogin;
import com.dreamdigitizers.mysound.presenters.interfaces.IPresenterPlayback;
import com.dreamdigitizers.mysound.presenters.interfaces.IPresenterSplash;
import com.dreamdigitizers.mysound.views.interfaces.IViewHome;
import com.dreamdigitizers.mysound.views.interfaces.IViewLogin;
import com.dreamdigitizers.mysound.views.interfaces.IViewPlayback;
import com.dreamdigitizers.mysound.views.interfaces.IViewSplash;

public class PresenterFactory {
    private static final String ERROR_MESSAGE__PRESENTER_NOT_FOUND = "There is no such PresenterBase class.";

    public static IPresenterBase createPresenter(Class pPresenterClass, IViewBase pView) {
        if(pPresenterClass.isAssignableFrom(IPresenterPlayback.class)) {
            return new PresenterPlayback((IViewPlayback) pView);
        }

        if(pPresenterClass.isAssignableFrom(IPresenterSplash.class)) {
            return new PresenterSplash((IViewSplash) pView);
        }

        if(pPresenterClass.isAssignableFrom(IPresenterLogin.class)) {
            return new PresenterLogin((IViewLogin) pView);
        }

        if(pPresenterClass.isAssignableFrom(IPresenterHome.class)) {
            return new PresenterHome((IViewHome) pView);
        }

        throw new RuntimeException(PresenterFactory.ERROR_MESSAGE__PRESENTER_NOT_FOUND);
    }
}
