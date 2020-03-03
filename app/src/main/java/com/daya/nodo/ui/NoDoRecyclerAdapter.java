package com.daya.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daya.nodo.R;
import com.daya.nodo.model.NoDo;

import java.util.List;

public class NoDoRecyclerAdapter extends RecyclerView.Adapter<NoDoRecyclerAdapter.NoDoViewHolder> {

    private LayoutInflater layoutInflater;
    private List<NoDo> noDoList;
    public NoDoRecyclerAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_item,null);
        return new NoDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder holder, int position) {
        if(noDoList != null){
            holder.textView.setText(noDoList.get(position).getNoDo());
        }
        else{
            holder.textView.setText("there is no item");
        }
    }
    public void setNODos(List<NoDo> NoDos){
        noDoList = NoDos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(noDoList != null)
            return noDoList.size();
        else
            return 0;
    }

    public class NoDoViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public NoDoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
