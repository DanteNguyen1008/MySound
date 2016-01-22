package com.dreamdigitizers.mysound.views.classes.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dreamdigitizers.androidbaselibrary.views.classes.activities.ActivityBase;
import com.dreamdigitizers.androidbaselibrary.views.classes.fragments.screens.ScreenBase;
import com.dreamdigitizers.androidsoundcloudapi.models.Me;
import com.dreamdigitizers.mysound.Constants;
import com.dreamdigitizers.mysound.R;
import com.dreamdigitizers.mysound.Share;
import com.dreamdigitizers.mysound.views.classes.fragments.screens.ScreenHome;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityMain extends ActivityBase {
    public static final String EXTRA__CURRENT_MEDIA_DESCRIPTION = "current_media_description";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private CircleImageView mImgAvatar;
    private TextView mLblMyName;

    private int mCurrentSelectedMenuId;

    public ActivityMain() {
        this.mCurrentSelectedMenuId = R.id.drawer_item__home;
    }

    @Override
    protected boolean handleNeededBackProcess() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.mDrawerLayout.closeDrawers();
            return true;
        }
        return false;
    }

    @Override
    protected void onPostCreate(Bundle pSavedInstanceState) {
        super.onPostCreate(pSavedInstanceState);
        this.mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onSaveInstanceState(Bundle pOutState) {
        super.onSaveInstanceState(pOutState);
        pOutState.putInt(Constants.BUNDLE_KEY__SELECTED_MENU_ID, this.mCurrentSelectedMenuId);
    }

    @Override
    protected void recoverInstanceState(Bundle pSavedInstanceState) {
        super.recoverInstanceState(pSavedInstanceState);
        this.mCurrentSelectedMenuId = pSavedInstanceState.getInt(Constants.BUNDLE_KEY__SELECTED_MENU_ID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.actionSearch:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setLayout() {
        this.setContentView(R.layout.activity__main);
    }

    @Override
    protected void retrieveItems() {
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.mNavigationView = (NavigationView) this.findViewById(R.id.navigationView);
        this.mImgAvatar = (CircleImageView) this.mNavigationView.getHeaderView(0).findViewById(R.id.imgAvatar);
        this.mLblMyName = (TextView) this.mNavigationView.getHeaderView(0).findViewById(R.id.lblMyName);
    }

    @Override
    protected void mapInformationToItems() {
        this.setSupportActionBar(this.mToolbar);
        this.setUpNavigationDrawer();

        Share.registerListener(new Share.OnDataChanged() {
            @Override
            public void onMeChanged(Me pNewMe, Me pOldMe) {
                Picasso
                        .with(ActivityMain.this)
                        .load(pNewMe.getAvatarUrl())
                        .placeholder(ContextCompat.getDrawable(ActivityMain.this, R.drawable.ic__default_profile))
                        .error(ContextCompat.getDrawable(ActivityMain.this, R.drawable.ic__default_profile))
                        .into(ActivityMain.this.mImgAvatar);
                ActivityMain.this.mLblMyName.setText(pNewMe.getFullName());
            }
        });
    }

    @Override
    protected ScreenBase getStartScreen() {
        return null;
    }

    @Override
    protected int getScreenContainerViewId() {
        return R.id.container;
    }

    private void setUpNavigationDrawer() {
        this.mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem pMenuItem) {
                ActivityMain.this.mDrawerLayout.closeDrawers();
                int id = pMenuItem.getItemId();
                return ActivityMain.this.navigationItemSelected(id);
            }
        });
        this.navigationItemSelected(this.mCurrentSelectedMenuId);

        this.mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                this.mDrawerLayout,
                this.mToolbar,
                R.string.desc__navigation_drawer_open,
                R.string.desc__navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        this.mDrawerLayout.setDrawerListener(this.mActionBarDrawerToggle);
    }

    private boolean navigationItemSelected(int pId) {
        this.mNavigationView.setCheckedItem(pId);
        this.mCurrentSelectedMenuId = pId;
        switch (pId) {
            case R.id.drawer_item__home:
                this.changeScreen(new ScreenHome());
                return true;
            case R.id.drawer_item__sounds:
                return true;
            case R.id.drawer_item__playlists:
                return true;
            case R.id.drawer_item__favorites:
                return true;
            default:
                return true;
        }
    }
}
