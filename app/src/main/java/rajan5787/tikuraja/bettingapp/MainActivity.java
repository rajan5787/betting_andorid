package rajan5787.tikuraja.bettingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<race_model> raceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RaceAdapter mAdapter;
    private Button btn_scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btn_scanner = (Button)findViewById(R.id.btn_scan);

        btn_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QrCode_Scanner.class);
                startActivity(i);
            }
        });
        mAdapter = new RaceAdapter(getApplicationContext(),raceList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();


    }

    private void prepareMovieData() {
//        race_model movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//        movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//         movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//         movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//         movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//         movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//         movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);
//        movie = new race_model("race 1","1","01/01/01","01/01/01","10");
//        raceList.add(movie);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.12:8080/";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("rr",response);
                            JSONObject obj1 = new JSONObject(response);
                            Log.i("www",obj1.toString());
                            String s = obj1.getString("arr");
                            JSONArray arr = new JSONArray(s);
                            Log.d("rr","arr");
                            for(int i = 0;i<arr.length();i++){
                                JSONObject obj = (JSONObject) arr.get(i);
                                //int nn = ((JSONArray)obj.get("horseIds")).length();
                                race_model mrace_model = new race_model(obj.get("raceId").toString(),
                                        obj.get("raceName").toString(),obj.get("startTime").toString(),
                                        obj.get("endTime").toString(),String.valueOf(5));
                                Log.i("count",String.valueOf(i));
                                raceList.add(mrace_model);
                            }
                            Log.i("count","dddd");
                            mAdapter.setdata(raceList);
                            mAdapter.notifyDataSetChanged();
                            Log.i("count","aaaa");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                Log.i("volyyError","Lodu error chhe ERROR");
                Log.i("volyyError",error.toString());

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
