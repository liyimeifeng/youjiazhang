package com.li.youjiazhang;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.li.youjiazhang.fragment.LearnChineseFragment;
import com.li.youjiazhang.fragment.EQFragment;
import com.li.youjiazhang.fragment.EntranceFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassifyActivity extends BaseActivity {

    @BindView(R.id.entrance_information)
    TextView entranceInformation;
    @BindView(R.id.chinese_study)
    TextView chineseStudy;
    @BindView(R.id.EQ_education)
    TextView EQEducation;
    private LearnChineseFragment learnChineseFragment;
    private EntranceFragment entranceFragment;
    private EQFragment eqFragment;
    private static final String TAG = "ClassifyActivity";
    private Toolbar toolbar;
    private TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_classify);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getToolbarTitle().setText("分类");
        getToolbarTitle().setVisibility(View.GONE);


        ButterKnife.bind(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        entranceFragment = EntranceFragment.newInstance("升学资讯");
        transaction.replace(R.id.classify_fragment, entranceFragment);
        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_classify;
    }

    @OnClick({R.id.entrance_information, R.id.chinese_study, R.id.EQ_education})
    public void onViewClicked(View view) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.entrance_information:
                if (entranceFragment == null) {
                    entranceFragment = EntranceFragment.newInstance("升学资讯");
                }
                transaction.replace(R.id.classify_fragment, entranceFragment);
                transaction.commit();
                break;
            case R.id.chinese_study:
                if (learnChineseFragment == null) {
                    learnChineseFragment = LearnChineseFragment.newInstance("语文学习");
                }
                transaction.replace(R.id.classify_fragment, learnChineseFragment);
                transaction.commit();

                break;
            case R.id.EQ_education:
                if (eqFragment == null) {
                    eqFragment = EQFragment.newInstance("情商咨询");
                }
                transaction.replace(R.id.classify_fragment, eqFragment);
                transaction.commit();
                break;
        }
    }
}
