package com.example.japan.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japan.Grammar;
import com.example.japan.R;
import com.example.japan.SplashScreenStartCourse;
import com.example.japan.model.ObjectGeneral;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
    private Context context;
    private List<ObjectGeneral> list;

    public CourseAdapter(Context context, List<ObjectGeneral> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getSrcImg());
        holder.textView.setText(list.get(position).getName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(list.get(position).getName(),list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void showDialog(String title, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setNegativeButton("BẮT ĐẦU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, SplashScreenStartCourse.class);
                intent.putExtra("idCourse",id);
                context.startActivity(intent);
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.white);
        alertDialog.show();
        alertDialog.getWindow().setLayout(500,200);
        //
        Button button = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        button.setMinWidth(500);
        button.setTextColor(Color.WHITE);
        button.setBackgroundResource(R.drawable.button_design);

    }
}

class CourseViewHolder extends RecyclerView.ViewHolder {
    CircleImageView imageView;
    TextView textView;
    CardView mCardView;
    CourseViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgCourse);
        textView = itemView.findViewById(R.id.txtCourse);
        mCardView = itemView.findViewById(R.id.cardViewItem);
    }
}