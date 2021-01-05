package com.example.japan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japan.ContentHandbook;
import com.example.japan.Lesson;
import com.example.japan.R;
import com.example.japan.model.VocabularyHandBook;
import com.example.japan.model.WordModel;

import java.util.ArrayList;

public class ContentHandBookAdapter extends RecyclerView.Adapter<ContentHandBookAdapter.ViewHolder> {

    private ArrayList<VocabularyHandBook> listData;
    ContentHandbook context;

    public ContentHandBookAdapter(ArrayList<VocabularyHandBook> listData, ContentHandbook context) {
        this.listData = listData;
        this.context = context;

    }
    @Override
    public ContentHandBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_handbook, parent, false);
        ContentHandBookAdapter.ViewHolder viewHolder = new ContentHandBookAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHandBookAdapter.ViewHolder holder, int position) {
        VocabularyHandBook vocabularyHandBook = listData.get(position);
        holder.textPageNumber.setText((position + 1) + "/" + listData.size());
        holder.txtWord.setText(vocabularyHandBook.getjWord());
        holder.txtMeanWord.setText(vocabularyHandBook.getVnWord());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout relativeLayout;
        public TextView txtWord, txtMeanWord, textPageNumber;
        public ImageView imgViewWord;
        public Button btn_speaker;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.rl1);
            txtWord = itemView.findViewById(R.id.idWord);
            txtMeanWord = itemView.findViewById(R.id.meanWord);
            textPageNumber = itemView.findViewById(R.id.pageNumberWord);
            imgViewWord = itemView.findViewById(R.id.imgWord);
            btn_speaker = itemView.findViewById(R.id.speaker);
        }
    }
}
