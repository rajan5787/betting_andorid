package rajan5787.tikuraja.bettingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RaceDetailActivity extends AppCompatActivity {

    private ArrayList<hourse_model> hourseList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HorseAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_detail);


        recyclerView = (RecyclerView) findViewById(R.id.rv_horse_detail);

        mAdapter = new HorseAdapter(getApplicationContext(),hourseList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        hourse_model movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);
        movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);
        movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);
        movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);
        movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);
        movie = new hourse_model("1","hourse 1","50","33");
        hourseList.add(movie);

        mAdapter.notifyDataSetChanged();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                "http:192.168.0.12;8080/gerRace", null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("data", "U1";

                return params;
            }

        };
    }
}
