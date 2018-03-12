package com.li.youjiazhang.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.li.youjiazhang.R;
import com.li.youjiazhang.dialog.MyDialog;
import com.li.youjiazhang.model.ChooseClassEntity;

import java.util.List;

/**
 * Created by lusl on 2018/3/10.
 */

public class ChooseClassAdapter extends RecyclerView.Adapter<ChooseClassAdapter.ViewHolder>{

    private List<ChooseClassEntity> chooseClassEntities;

    public ChooseClassAdapter(List<ChooseClassEntity> chooseClassEntities) {
        this.chooseClassEntities = chooseClassEntities;
    }

    @Override
    public ChooseClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_chooseclass, parent, false);
        ChooseClassAdapter.ViewHolder viewHolder = new ChooseClassAdapter.ViewHolder(view);

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(view.getContext());
                dialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChooseClassAdapter.ViewHolder holder, int position) {
        ChooseClassEntity chooseClassEntity = chooseClassEntities.get(position);
    }


    @Override
    public int getItemCount() {
        return chooseClassEntities.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public ViewHolder(View view) {
            super(view);
           button =(Button) view.findViewById(R.id.sign_up);
        }
    }

}
