package com.li.youjiazhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.li.youjiazhang.activity.NewsActivity;
import com.li.youjiazhang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class EntranceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.private_school)
    TextView privateSchool;
    @BindView(R.id.school_introduce)
    Button schoolIntroduce;
    @BindView(R.id.private_school_info)
    Button privateSchoolInfo;
    @BindView(R.id.public_school)
    TextView publicSchool;
    @BindView(R.id.qingyang_district)
    Button qingyangDistrict;
    @BindView(R.id.jingjinag_district)
    Button jingjinagDistrict;
    @BindView(R.id.chenghua_district)
    Button chenghuaDistrict;
    @BindView(R.id.jinniu_district)
    Button jinniuDistrict;
    @BindView(R.id.gaoxin_district)
    Button gaoxinDistrict;
    @BindView(R.id.wuhou_district)
    Button wuhouDistrict;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public EntranceFragment() {
        // Required empty public constructor
    }

    public static EntranceFragment newInstance(String param1) {
        EntranceFragment fragment = new EntranceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entrance, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.private_school, R.id.school_introduce, R.id.private_school_info, R.id.public_school, R.id.qingyang_district, R.id.jingjinag_district, R.id.chenghua_district, R.id.jinniu_district, R.id.gaoxin_district, R.id.wuhou_district})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.private_school:
                jumpToInforView();
                break;
            case R.id.school_introduce:
                jumpToInforView();
                break;
            case R.id.private_school_info:
                jumpToInforView();
                break;
            case R.id.public_school:
                jumpToInforView();

                break;
            case R.id.qingyang_district:
                jumpToInforView();

                break;
            case R.id.jingjinag_district:
                jumpToInforView();

                break;
            case R.id.chenghua_district:
                jumpToInforView();

                break;
            case R.id.jinniu_district:
                jumpToInforView();

                break;
            case R.id.gaoxin_district:
                jumpToInforView();

                break;
            case R.id.wuhou_district:
                jumpToInforView();

                break;
        }
    }

    private void jumpToInforView() {
        Intent intent = new Intent(getContext(), NewsActivity.class);
        startActivity(intent);

    }
}
