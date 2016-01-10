package com.dreamdigitizers.mysound.views.classes.fragments.screens;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamdigitizers.androidbaselibrary.views.classes.fragments.screens.ScreenBase;
import com.dreamdigitizers.androidbaselibrary.views.classes.services.ServiceMediaPlayer;
import com.dreamdigitizers.androidsoundcloudapi.models.Me;
import com.dreamdigitizers.mysound.R;
import com.dreamdigitizers.mysound.Share;
import com.dreamdigitizers.mysound.presenters.classes.PresenterFactory;
import com.dreamdigitizers.mysound.presenters.interfaces.IPresenterHome;
import com.dreamdigitizers.mysound.views.interfaces.IViewHome;

public class ScreenHome extends ScreenBase<IPresenterHome> implements IViewHome {
    @Override
    protected IPresenterHome createPresenter() {
        return (IPresenterHome) PresenterFactory.createPresenter(IPresenterHome.class, this);
    }

    @Override
    protected View loadView(LayoutInflater pInflater, ViewGroup pContainer) {
        View rootView = pInflater.inflate(R.layout.screen__home, pContainer, false);
        return rootView;
    }

    @Override
    protected void retrieveScreenItems(View pView) {

    }

    @Override
    protected void mapInformationToScreenItems(View pView) {
        this.mPresenter.me(Share.getAccessToken());
    }

    @Override
    protected int getTitle() {
        return R.string.title__screen_home;
    }

    @Override
    public void dispatchMe(Me pMe) {
        Share.setMe(pMe);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.getContext().startService(new Intent(ServiceMediaPlayer.ACTION__PLAY));
    }
}
