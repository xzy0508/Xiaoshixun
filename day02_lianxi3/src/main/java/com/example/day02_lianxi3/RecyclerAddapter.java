package com.example.day02_lianxi3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAddapter extends RecyclerView.Adapter {

    ArrayList<ResultData.DataBean.DatasBean> datasBeans;
    Context basecontext;
    private final int TOP=1;
    private final int MODDEN=2;
    private final int BOTTOMLEFT=3;
    private final int BOTTOMRIGHT=4;

    public RecyclerAddapter(ArrayList<ResultData.DataBean.DatasBean> datasBeans, Context basecontext) {
        this.datasBeans = datasBeans;
        this.basecontext = basecontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case TOP:
                View inflate = LayoutInflater.from(basecontext).inflate(R.layout.layout_top, viewGroup, false);
                return new TopViewHolder(inflate);
            case MODDEN:
                View inflate1 = LayoutInflater.from(basecontext).inflate(R.layout.layout_modden, viewGroup, false);
                return new ModdenViewHolder(inflate1);
            case BOTTOMLEFT:
                View inflate2 = LayoutInflater.from(basecontext).inflate(R.layout.layout_bottomleft, viewGroup, false);
                return new TopViewHolder(inflate2);
            case BOTTOMRIGHT:
                View inflate3 = LayoutInflater.from(basecontext).inflate(R.layout.layout_bottomrigth, viewGroup, false);
                return new TopViewHolder(inflate3);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class TopViewHolder extends RecyclerView.ViewHolder{
        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ModdenViewHolder extends RecyclerView.ViewHolder{
        public ModdenViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class BottomLeftViewHolder extends RecyclerView.ViewHolder{
        public BottomLeftViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class BottomRigthViewHolder extends RecyclerView.ViewHolder{
        public BottomRigthViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
