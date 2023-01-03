package com.example.ex085;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<item> items;
    private ItemClickListener mItemListener;

    public MyAdapter(Context context, List<item> items, ItemClickListener mItemListener)
    {
        this.context = context;
        this.items = items;
        this.mItemListener = mItemListener;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(items.get(position).getNumber());
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
