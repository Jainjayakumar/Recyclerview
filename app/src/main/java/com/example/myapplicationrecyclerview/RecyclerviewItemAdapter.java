package com.example.myapplicationrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewItemAdapter extends RecyclerView.Adapter<RecyclerviewItemAdapter.MyViewHolder> {

    private List<Items> itemsList;
    private ClickListener clickListener;

    RecyclerviewItemAdapter(List<Items> mItemList){
        this.itemsList = mItemList;
    }

    @Override
    public RecyclerviewItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewItemAdapter.MyViewHolder holder, final int position) {
        final Items item = itemsList.get(position);
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name,price;
        private LinearLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            itemLayout =  itemView.findViewById(R.id.itemLayout);
        }
    }
}