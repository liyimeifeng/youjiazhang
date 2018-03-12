package com.li.youjiazhang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.li.youjiazhang.R;
import com.li.youjiazhang.adapter.FaqAdapter;
import com.li.youjiazhang.model.Interaction;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InteractionFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.spinner_sort)
    Spinner spinnerSort;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    Unbinder unbinder;
    @BindView(R.id.fab2)
    FloatingActionButton fab2;
    @BindView(R.id.fab3)
    FloatingActionButton fab3;
    @BindView(R.id.fab1)
    FloatingActionButton fab1;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public InteractionFragment() {
        // Required empty public constructor
    }

    public static InteractionFragment newInstance(String param1) {
        InteractionFragment fragment = new InteractionFragment();
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
        View view = inflater.inflate(R.layout.fragment_interaction, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        adapter_sort = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, list_sort);
        adapter_sort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapter_sort);
        spinnerSort.setOnItemSelectedListener(this);

        adapter_type = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, list_type);
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter_type);
        spinnerType.setOnItemSelectedListener(this);

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycler_faq);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        FaqAdapter adapter = new FaqAdapter(interactionList);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

    }

    // 数据源
    private String[] sort = {"默认排序", "最新", "最热"};
    private String[] type = {"全部类型", "升学问题", "课程及其他问题咨询"};
    private List<String> list_type = new ArrayList<>();

    private List<String> list_sort = new ArrayList<>();
    private ArrayAdapter adapter_sort = null;
    private ArrayAdapter adapter_type = null;
    private List<Interaction> interactionList = new ArrayList<>();


    private void initData() {
        for (int i = 0; i < sort.length; i++) {
            list_sort.add(sort[i]);
        }
        for (int i = 0; i < type.length; i++) {
            list_type.add(type[i]);
        }
        interactionList.clear();
        for (int j = 0; j < 30; j++) {
            Interaction interaction = new Interaction();
            interaction.setPortrait(R.mipmap.ic_face);
            interaction.setName("张三三");
            interaction.setTime("2018-03-10");
            interaction.setQuestion("我孩子是八年级我要报八年级的班,我想问问........");
            interaction.setAnswer_num("2");
            interaction.setAnswer("可以的，周一就可以上课");
            interactionList.add(interaction);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String type = (String) adapter_sort.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private boolean isShowFloatButton;

    @OnClick({R.id.fab2, R.id.fab3, R.id.fab1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab1:
                if (!isShowFloatButton){
                    fab2.setVisibility(View.VISIBLE);
                    fab3.setVisibility(View.VISIBLE);
                    isShowFloatButton = true;

                }else{
                    fab2.setVisibility(View.INVISIBLE);
                    fab3.setVisibility(View.INVISIBLE);
                    isShowFloatButton = false;

                }

                break;
        }
    }
}
