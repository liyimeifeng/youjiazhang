package com.li.youjiazhang.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.li.youjiazhang.R;
import com.li.youjiazhang.model.StudyModel;

import java.util.List;

/**
 * Created by lusl on 2018/3/11.
 */

public class StudyModelAdapter extends RecyclerView.Adapter<StudyModelAdapter.ViewHolder> {

    private List<StudyModel> studyModels ;

    public StudyModelAdapter(List<StudyModel> studyModels) {
        this.studyModels = studyModels;
    }
    @Override
    public void onBindViewHolder(StudyModelAdapter.ViewHolder holder, int position) {
//        StudyModel studyModel = studyModels.get(position);
//        holder.nameView.setText(studyModel.getName());
//        holder.timeView.setText(studyModel.getTime());
//        holder.answernumView.setText(studyModel.getAnswer_num());
////        holder.answerView.setText(interaction.getAnswer());
//        holder.questionView.setText(studyModel.getQuestion());
//        holder.portraitView.setImageResource(studyModel.getPortrait());

    }

    @Override
    public int getItemCount() {
        return studyModels.size();
    }

    @Override
    public StudyModelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_studyclass, parent, false);
        StudyModelAdapter.ViewHolder viewHolder = new StudyModelAdapter.ViewHolder(view);
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameView, questionView,answerView,timeView,typeView,answernumView;
        ImageView portraitView;

        public ViewHolder(View view) {
            super(view);
//            nameView = (TextView) view.findViewById(R.id.recyclerview_faq_name);
//            questionView = (TextView) view.findViewById(R.id.recyclerview_faq_question);
//            answernumView = (TextView) view.findViewById(R.id.recyclerview_faq_answer_num);
//            timeView = (TextView) view.findViewById(R.id.recyclerview_faq_time);
//            typeView = (TextView) view.findViewById(R.id.recyclerview_faq_type);
//            portraitView = (ImageView) view.findViewById(R.id.recyclerview_faq_portrait);

        }

    }
}
