package com.li.youjiazhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.li.youjiazhang.fragment.InteractionFragment;
import com.li.youjiazhang.fragment.MyInforFragment;
import com.li.youjiazhang.fragment.NewsFragment;
import com.li.youjiazhang.fragment.StudyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.news)
    TextView news;
    @BindView(R.id.study)
    TextView study;
    @BindView(R.id.interaction)
    TextView interaction;
    @BindView(R.id.myinfor)
    TextView myinfor;
    private NewsFragment newFragment;
    private StudyFragment studyFragment;
    private InteractionFragment interactionFragment;
    private MyInforFragment myInforFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getSearchView().setVisibility(View.VISIBLE);
        getToolbarTitle().setVisibility(View.GONE);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        newFragment = NewsFragment.newInstance("资讯");
        transaction.replace(R.id.fragment, newFragment);
        transaction.commit();
//        initBottomBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isShowBacking() {
        return false;
    }

    @OnClick({R.id.news, R.id.study, R.id.interaction, R.id.myinfor})
    public void onViewClicked(View view) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.news:
                getToolbar().setVisibility(View.VISIBLE);

                if (newFragment == null) {
                    newFragment = NewsFragment.newInstance("资讯");
                }
                transaction.replace(R.id.fragment, newFragment);
                transaction.commit();
                break;
            case R.id.study:
                getToolbar().setVisibility(View.VISIBLE);

                if (studyFragment == null) {
                    studyFragment = StudyFragment.newInstance("学习");
                }
                transaction.replace(R.id.fragment, studyFragment);
                transaction.commit();

                break;
            case R.id.interaction:
                getToolbar().setVisibility(View.VISIBLE);
                if (interactionFragment == null) {
                    interactionFragment = InteractionFragment.newInstance("互动");
                }
                transaction.replace(R.id.fragment, interactionFragment);
                transaction.commit();

                break;
            case R.id.myinfor:
                getToolbar().setVisibility(View.GONE);
                if (myInforFragment == null) {
                    myInforFragment = MyInforFragment.newInstance("我的");
                }
                transaction.replace(R.id.fragment, myInforFragment);
                transaction.commit();

                break;
        }
    }

    @Override
    public void onTabSelected(int position) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, ClassifyActivity.class);
                startActivity(intent);
                Toast.makeText(this, "即将跳转", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
    }

    @Override
    public void onTabReselected(int position) {

    }

}
