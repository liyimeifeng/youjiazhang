package com.li.youjiazhang.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.li.youjiazhang.R;
import com.li.youjiazhang.WebViewActivity;
import com.li.youjiazhang.loader.Myloader;
import com.li.youjiazhang.model.Information;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lusl on 2018/3/10.
 */

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> implements OnBannerListener{

    private List<Information> informationList;

    public InformationAdapter(List<Information> informations) {
        informationList = informations;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_infomation, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "即将跳转详情页", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                view.getContext().startActivity(intent);

            }
        });
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "即将跳转详情页", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Information infor = informationList.get(position);
        holder.imageView.setImageResource(infor.getDrawble());
        holder.textView.setText(infor.getMessage());
        initView(holder.banner);
        if (position != 0){
            holder.banner.setVisibility(View.GONE);
        }else{
            holder.banner.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    @Override
    public void OnBannerClick(int position) {

    }

    /**
     * 初始化轮播图
     * @param banner
     */
    private void initView(Banner banner) {
        Integer[] images={R.drawable.porridge,R.drawable.porridge,R.drawable.porridge};
        List list = Arrays.asList(images);
        banner.setImages(list).setImageLoader(new Myloader()).start();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView,imageViewInformation;
        Banner banner;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.recylerview_infomation_text);
            imageView = (ImageView) view.findViewById(R.id.recylerview_infomation_image);
            banner = (Banner) view.findViewById(R.id.banner);
        }
    }

}
