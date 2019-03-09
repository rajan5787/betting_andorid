package rajan5787.tikuraja.bettingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by rajanpipaliya on 08/03/19.
 */

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<race_model> raceList;

    public RaceAdapter(Context mContext, ArrayList<race_model> list){
        this.context = mContext;
        this.raceList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_race_detail,parent,false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        race_model mrace_model = raceList.get(position);
        holder.raceName.setText(mrace_model.getRace_name());
        holder.startTime.setText(mrace_model.getStartTime());
        holder.endTime.setText(mrace_model.getEndTime());
        holder.total_player.setText(mrace_model.getRace_player());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,RaceDetailActivity.class);
                i.putExtra("race_id",raceList.get(position).getRace_id());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("count",String.valueOf(raceList.size()));
        return raceList.size();
    }


    public void setdata(ArrayList<race_model> list){
        this.raceList = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView startTime,endTime, total_player,raceName;
        public ImageView image;


        public MyViewHolder(View view){
            super(view);
            startTime = (TextView) view.findViewById(R.id.startTime);
            endTime = (TextView) view.findViewById(R.id.endTime);
            raceName = (TextView)view.findViewById(R.id.raceName);
            total_player = (TextView) view.findViewById(R.id.playes);
            image = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

}
