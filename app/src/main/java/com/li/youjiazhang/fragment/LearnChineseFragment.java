package com.li.youjiazhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.li.youjiazhang.NewsActivity;
import com.li.youjiazhang.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LearnChineseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.shuchongzhijia)
    TextView shuchongzhijia;
    @BindView(R.id.miaobishenghua)
    TextView miaobishenghua;
    @BindView(R.id.zuowensucai)
    Button zuowensucai;
    @BindView(R.id.huojiangwenzhang)
    Button huojiangwenzhang;
    @BindView(R.id.xinlinjinnang)
    TextView xinlinjinnang;
    @BindView(R.id.kewaituozhan)
    Button kewaituozhan;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static LearnChineseFragment newInstance(String param1) {
        LearnChineseFragment fragment = new LearnChineseFragment();
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
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.shuchongzhijia, R.id.miaobishenghua, R.id.zuowensucai, R.id.huojiangwenzhang, R.id.xinlinjinnang, R.id.kewaituozhan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shuchongzhijia:
                jumpToInforView();
                break;
            case R.id.miaobishenghua:
                jumpToInforView();

                break;
            case R.id.zuowensucai:
                jumpToInforView();

                break;
            case R.id.huojiangwenzhang:
                jumpToInforView();

                break;
            case R.id.xinlinjinnang:
                jumpToInforView();

                break;
            case R.id.kewaituozhan:
                jumpToInforView();

                break;
        }
    }


    private void jumpToInforView() {
        Intent intent = new Intent(getContext(), NewsActivity.class);
        startActivity(intent);

    }
}
