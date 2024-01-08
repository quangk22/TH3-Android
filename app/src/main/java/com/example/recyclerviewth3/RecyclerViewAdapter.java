package com.example.recyclerviewth3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHoder> {
    List<President> presidentList;
    Context context;

    public RecyclerViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president,parent,false);
        MyViewHoder hoder = new MyViewHoder(view);

        return hoder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        holder.tv_presName.setText(presidentList.get(position).getName());
        holder.tv_Date.setText(String.valueOf(presidentList.get(position).getDateOfElection()));
        Glide.with(this.context).load(presidentList.get(position).getImageURL()).into(holder.iv_presPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , AddEditOne.class);
                intent.putExtra("id",presidentList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    public class MyViewHoder extends  RecyclerView.ViewHolder{
        ImageView iv_presPic;
        TextView tv_presName,tv_Date;
        ConstraintLayout parentLayout;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            iv_presPic = itemView.findViewById(R.id.iv_peresident);
            tv_presName = itemView.findViewById(R.id.tv_name);
            tv_Date = itemView.findViewById(R.id.tv_date);
            parentLayout = itemView.findViewById(R.id.oneLinePresidentLayout);
        }
    }
}
