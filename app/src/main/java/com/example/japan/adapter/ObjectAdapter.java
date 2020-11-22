package com.example.japan.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.japan.Grammar;
import com.example.japan.R;
import com.example.japan.model.GrammarCall;
import com.example.japan.model.ObjectGeneral;

import java.util.List;

public class ObjectAdapter extends BaseAdapter {
    public Context context;
    private int layout;
    private List<ObjectGeneral> list;

    public ObjectAdapter(Context context, int layout, List<ObjectGeneral> list) {

        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TableRow tableRow;
        TextView textRow;
        ImageView img;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
            if(view == null){
                holder = new ViewHolder();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(layout,null);

                holder.textRow = (TextView) view.findViewById(R.id.title);
                holder.img = (ImageView) view.findViewById(R.id.iconObject);
                holder.tableRow = (TableRow) view.findViewById(R.id.tableRowId);
                view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        final ObjectGeneral objectGeneral = list.get(i);
        holder.textRow.setText(objectGeneral.getName());
//        Log.d("aaa","event");
//        grammarCall.call(objectGeneral.getId());
//        holder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        return view;
    }
}
