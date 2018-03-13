package com.li.youjiazhang.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.li.youjiazhang.BaseActivity;
import com.li.youjiazhang.R;
import com.li.youjiazhang.adapter.ChooseClassAdapter;
import com.li.youjiazhang.model.ChooseClassEntity;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCourseClassActivity extends BaseActivity {

    @BindView(R.id.quarter)
    TextView quarter;
    @BindView(R.id.subject)
    TextView subject;
    @BindView(R.id.class_type)
    Button classType;
    @BindView(R.id.campus)
    Button campus;
    @BindView(R.id.date)
    Button date;

    private List<ChooseClassEntity> chooseClassEntityList = new ArrayList<>();
    String[] items_quarter = { "2018春季" };
    String[] items_subjects = { "不限","语文","书法" };
    String[] items_classtype = { "不限","培优班","入门班","尖子班","提高班" };
    String[] items_campus = { "不限","天府广场校区","汇源校区","抚琴校区","金沙校区","建设路校区","阳光新业校区","桐梓林校区","锦城大道校区","龙腾校区","肖家河校区","新华公园校区","468校区","蜀汉路校区" };
    String[] items_date = { "不限","星期一","星期二","星期三","星期四","星期五" ,"星期六","星期天"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initClassInfo();
        getSearchView().setVisibility(View.GONE);
        getToolbarTitle().setText("选课报班");

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerview_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        ChooseClassAdapter adapter = new ChooseClassAdapter(chooseClassEntityList);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_course_class;
    }


    private void initClassInfo() {
        for (int j = 0; j < 30; j++) {
            ChooseClassEntity chooseClassEntity = new ChooseClassEntity();
            chooseClassEntity.setIntroduction("一年级-汇源校区-星期日-2018春季-语文-培优班");
            chooseClassEntity.setDate("开课时间：2018-03-11 -2018-06-17| 10:30 - 12:30");
            chooseClassEntityList.add(chooseClassEntity);
        }
    }

    @OnClick({R.id.quarter, R.id.subject, R.id.class_type, R.id.campus, R.id.date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quarter:
                showListDialog( items_quarter,R.id.quarter);
                break;
            case R.id.subject:
                showListDialog( items_subjects,R.id.subject);
                break;
            case R.id.class_type:
                showListDialog( items_classtype,R.id.class_type);
                break;
            case R.id.campus:
                showListDialog( items_campus,R.id.campus);
                break;
            case R.id.date:
                showListDialog( items_date,R.id.date);
                break;

        }
    }

    private void showListDialog( final String[] items, final int viewID) {
        AlertDialog.Builder listDialog = new AlertDialog.Builder(this);
        listDialog.setTitle("请选择");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                if (viewID ==  R.id.quarter){
                    quarter.setText(items[which]);
                }else if (viewID ==  R.id.subject){
                    subject.setText(items[which]);
                }else if (viewID ==  R.id.class_type){
                    classType.setText(items[which]);
                }else if (viewID ==  R.id.campus){
                    campus.setText(items[which]);
                }else if (viewID ==  R.id.date){
                    date.setText(items[which]);
                }

            }
        });
        listDialog.show();
    }
}
