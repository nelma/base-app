package com.example.baseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private View.OnClickListener listener;

    public ItemAdapter(List<Item> items, View.OnClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.bindView(item, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
        }

        void bindView(Item item, View.OnClickListener listener) {

            TextView edName = itemView.findViewById(R.id.tvName);
            TextView edDescription = itemView.findViewById(R.id.tvDescription);

            edName.setText(item.getName());
            edDescription.setText(item.getDescription());

            itemView.setOnClickListener(listener);
        }
    }
}
