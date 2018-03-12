package com.li.youjiazhang.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.li.youjiazhang.R;
import com.li.youjiazhang.model.Interaction;

import java.util.List;

/**
 * Created by lusl on 2018/3/10.
 */

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    private List<Interaction> interactions ;

    public FaqAdapter(List<Interaction> informations) {
        interactions = informations;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Interaction interaction = interactions.get(position);
        holder.nameView.setText(interaction.getName());
        holder.timeView.setText(interaction.getTime());
        holder.answernumView.setText(interaction.getAnswer_num());
//        holder.answerView.setText(interaction.getAnswer());
        holder.questionView.setText(interaction.getQuestion());

        holder.portraitView.setImageResource(interaction.getPortrait());

    }

    @Override
    public int getItemCount() {
        return interactions.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_faq, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.questionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        viewHolder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return viewHolder;
    }

    public void setType(String type,ViewHolder viewHolder){

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameView, questionView,answerView,timeView,typeView,answernumView;
        ImageView portraitView;

        public ViewHolder(View view) {
            super(view);
            nameView = (TextView) view.findViewById(R.id.recyclerview_faq_name);
            questionView = (TextView) view.findViewById(R.id.recyclerview_faq_question);
            answernumView = (TextView) view.findViewById(R.id.recyclerview_faq_answer_num);
            timeView = (TextView) view.findViewById(R.id.recyclerview_faq_time);
            typeView = (TextView) view.findViewById(R.id.recyclerview_faq_type);
            portraitView = (ImageView) view.findViewById(R.id.recyclerview_faq_portrait);

        }

    }
}
