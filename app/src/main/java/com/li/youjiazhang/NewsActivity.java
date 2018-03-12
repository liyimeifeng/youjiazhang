package com.li.youjiazhang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.li.youjiazhang.adapter.InformationAdapter;
import com.li.youjiazhang.model.Information;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private List<Information> informations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        initInformation();
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerview_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        InformationAdapter adapter = new InformationAdapter(informations);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    private void initInformation() {
        for (int j = 0; j < 30; j++) {
            Information infor = new Information();
            infor.setDrawble(R.mipmap.ic_moutain);
            infor.setMessage("成都中小学3月4号开学新学期校历请收好...........");
            informations.add(infor);
        }
    }
}
