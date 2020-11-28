package com.example.japan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japan.R;

import java.util.ArrayList;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {
    private ArrayList<String> listData;

    public LessonAdapter(ArrayList<String> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_front,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.layout_container.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                flipCard();
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {
     holder.text_Vocabulary.setText(listData.get(position));


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public class ViewHolder  extends  RecyclerView.ViewHolder{
        LinearLayout layout_container;
        public TextView text_Vocabulary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_container = itemView.findViewById(R.id.layout_front);
            text_Vocabulary = itemView.findViewById(R.id.jpWord);
     
        }
    }

}
