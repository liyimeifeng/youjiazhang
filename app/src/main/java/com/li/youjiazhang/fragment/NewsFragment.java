package com.li.youjiazhang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.li.youjiazhang.model.Information;
import com.li.youjiazhang.adapter.InformationAdapter;
import com.li.youjiazhang.R;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Information> informations = new ArrayList<>();

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         initInformation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recyclerview_news);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        InformationAdapter adapter = new InformationAdapter(informations);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }


    private void initInformation() {
        informations.clear();
        for (int j = 0; j < 30; j++) {
            Information infor = new Information();
            infor.setDrawble(R.mipmap.ic_flower);
            infor.setMessage("【重磅】成都中小学3月4号开学新学期校历请收好...........");
            informations.add(infor);
        }
    }
}
