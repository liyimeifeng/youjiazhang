package com.li.youjiazhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.li.youjiazhang.activity.ChooseCourseClassActivity;
import com.li.youjiazhang.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyInforFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.choose_course_class)
    TextView chooseCourseClass;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;
    Unbinder unbinder;
    private static final String TAG = "MyInforFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyInforFragment() {
        // Required empty public constructor
    }

    public static MyInforFragment newInstance(String param1) {
        MyInforFragment fragment = new MyInforFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        Log.e(TAG, "newInstance: " );
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
        Log.e(TAG, "onCreateView: ***************" );
        View view = inflater.inflate(R.layout.fragment_my_infor, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.choose_course_class)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), ChooseCourseClassActivity.class);
        getContext().startActivity(intent);
    }
}
