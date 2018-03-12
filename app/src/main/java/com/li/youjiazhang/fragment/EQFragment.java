package com.li.youjiazhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.li.youjiazhang.NewsActivity;
import com.li.youjiazhang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class EQFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.xuntao)
    TextView xuntao;
    @BindView(R.id.huati)
    TextView huati;
    @BindView(R.id.peiyang)
    TextView peiyang;
    Unbinder unbinder;
    private String mParam1;
    private String mParam2;


    public EQFragment() {
        // Required empty public constructor
    }

    public static EQFragment newInstance(String param1) {
        EQFragment fragment = new EQFragment();
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
        View view = inflater.inflate(R.layout.fragment_eq, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.xuntao, R.id.huati, R.id.peiyang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xuntao:
                jumpToInforView();
                break;
            case R.id.huati:
                jumpToInforView();
                break;
            case R.id.peiyang:
                jumpToInforView();
                break;
        }
    }

    private void jumpToInforView() {
        Intent intent = new Intent(getContext(), NewsActivity.class);
        startActivity(intent);

    }
}
