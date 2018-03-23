package com.li.youjiazhang;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.li.youjiazhang.activity.ClassifyActivity;
import com.li.youjiazhang.fragment.InteractionFragment;
import com.li.youjiazhang.fragment.MyInforFragment;
import com.li.youjiazhang.fragment.NewsFragment;
import com.li.youjiazhang.fragment.StudyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.navigation)
    BottomNavigationView mNavigationView;
    private NewsFragment newFragment;
    private StudyFragment studyFragment;
    private InteractionFragment interactionFragment;
    private MyInforFragment myInforFragment;
    private long currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getSearchView().setVisibility(View.VISIBLE);
        getToolbarTitle().setVisibility(View.GONE);
        mNavigationView.setOnNavigationItemSelectedListener(this);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (item.getItemId()) {
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
        return true;
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentTime > 2000) {
                Toast.makeText(this, "再按一次返回退出应用", Toast.LENGTH_SHORT).show();
                currentTime = System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
            return true;  //这句话很关键，返回true即表示事件自己消费，不再往下面传递
        }
        return super.onKeyDown(keyCode, event);
    }

}
