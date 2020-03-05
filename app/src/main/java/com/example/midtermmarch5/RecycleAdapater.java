package com.example.midtermmarch5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecycleAdapater extends RecyclerView.Adapter<RecycleAdapater.ViewHolder> {
    private ArrayList<ConsolidatedWeather> arrypro;
    private Context context;
    private View.OnClickListener itemlistener;


        public RecycleAdapater(ArrayList<ConsolidatedWeather> arrypro, Context context) {
            this.arrypro = arrypro;
            this.context = context;
        }
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
                return new ViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapater.ViewHolder holder, int position) {


    }


            public void setClickListener(View.OnClickListener itemListener) {
                this.itemlistener = itemListener;
            }
            @Override
            public int getItemCount () {   return arrypro.size();

            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pkimg;
        public ViewHolder(View itemView){
            super(itemView);

            pkimg = itemView.findViewById(R.id.img_pk);

            itemView.setTag(this);
            itemView.setOnClickListener(itemlistener);

        }
}




    }
