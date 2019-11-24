package com.example.xiaoshixun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaoshixun.R;
import com.example.xiaoshixun.bean.ResultData;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<ResultData.DataBean.ListBean> listBeans;
    Context basecontext;
    boolean radio=false;

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public RecyclerAdapter(List<ResultData.DataBean.ListBean> listBeans, Context basecontext) {
        this.listBeans = listBeans;
        this.basecontext = basecontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(basecontext).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        /*ResultData.DataBean.ListBean listBean = listBeans.get(i);
        for (int j = 0; j < listBeans.size(); j++) {
            if (radio==true){
                viewHolder.button_item.setChecked(false);
            }
        }*/

        Glide.with(basecontext).load(listBeans.get(i).getPic()).into(viewHolder.imagm_item);
        viewHolder.price_item.setText(listBeans.get(i).getName());
        viewHolder.money_item.setText(listBeans.get(i).getPrice()+"");

        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio==true){
                    viewHolder.button_item.setChecked(false);
                }else {
                    viewHolder.button_item.setChecked(true);
                }
            }
        });*/

        int id = viewHolder.itemView.getId();
        Log.i("1111111111", "onBindViewHolder: "+id);
        /*long itemId = viewHolder.getItemId();
        Log.i("7777","onBindViewHolder: "+itemId);*/
        if (id==-1){
            viewHolder.button_item.setChecked(true);
        }else {
//            viewHolder.button_item.setChecked(false);
            viewHolder.button_item.setClickable(true);
        }
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RadioButton button_item;
        private final ImageView imagm_item;
        private final TextView price_item;
        private final TextView money_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button_item = itemView.<RadioButton>findViewById(R.id.button_item);
            imagm_item = itemView.<ImageView>findViewById(R.id.image_item);
            price_item = itemView.<TextView>findViewById(R.id.price_item);
            money_item = itemView.<TextView>findViewById(R.id.money_item);
        }
    }

    ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }

    public interface ClickItem{
        void onClick(int pos);
    }
}
