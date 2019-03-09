package rajan5787.tikuraja.bettingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rajanpipaliya on 08/03/19.
 */

public class HorseAdapter extends RecyclerView.Adapter<HorseAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<hourse_model> hourseList;

    public HorseAdapter(Context mContext, ArrayList<hourse_model> list){
        this.context = mContext;
        this.hourseList = list;
    }

    @Override
    public HorseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hourse,parent,false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,RaceDetailActivity.class);
                context.startActivity(i);
            }
        });
        return new HorseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HorseAdapter.MyViewHolder holder, int position) {

        hourse_model mhourse_model = hourseList.get(position);
        holder.hourse_name.setText(mhourse_model.getHourse_name());
        holder.hourse_fitness_level.setText(mhourse_model.getHourse_fitness_level());
        holder.hourse_breed.setText(mhourse_model.getHourse_breed());
    }


    @Override
    public int getItemCount() {
        return hourseList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView hourse_name,hourse_fitness_level, hourse_breed;
        public ImageView image;

        public MyViewHolder(View view){
            super(view);
            hourse_name = (TextView) view.findViewById(R.id.hourse_name);
            hourse_fitness_level = (TextView) view.findViewById(R.id.hourse_fitness);
            hourse_breed = (TextView) view.findViewById(R.id.hourse_breed);
            //image = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

}
