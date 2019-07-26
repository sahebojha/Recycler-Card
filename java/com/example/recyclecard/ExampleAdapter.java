package com.example.recyclecard;

import android.support.annotation.NonNull;
import android.support.asynclayoutinflater.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {


    //6.2
    private ArrayList<example_item> mexampleList;

    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        //4
        public ImageView imageView;
        public TextView textView;


        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //4
            imageView =itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);
        }
    }
    //6.1
    public ExampleAdapter(ArrayList<example_item> exampleList ){
        mexampleList = exampleList;
    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //5
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item,
                        viewGroup,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
    //7
        example_item currentitem = mexampleList.get(i);
        exampleViewHolder.imageView.setImageResource(currentitem.getmImageResourse());
        exampleViewHolder.textView.setText(currentitem.getmText());
    }

    @Override
    public int getItemCount() {
        return mexampleList.size();
    }


}
