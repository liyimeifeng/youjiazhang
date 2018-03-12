package com.li.youjiazhang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.li.youjiazhang.R;
import com.li.youjiazhang.adapter.StudyModelAdapter;
import com.li.youjiazhang.model.StudyModel;
import java.util.ArrayList;
import java.util.List;

public class StudyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<StudyModel> studyModels = new ArrayList<>();

    public StudyFragment() {
        // Required empty public constructor
    }


    public static StudyFragment newInstance(String param1) {
        StudyFragment fragment = new StudyFragment();
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
        initInformation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recyclerview_news);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        StudyModelAdapter adapter = new StudyModelAdapter(studyModels);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    private void initInformation() {
            studyModels.clear();
        for (int j = 0; j < 4; j++) {
            StudyModel studyModel = new StudyModel();
            studyModels.add(studyModel);
        }
    }
}
