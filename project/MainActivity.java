package com.example.project;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.example.project.CustomAdapter;

    public class MainActivity extends AppCompatActivity{
        ListView listView;
        ArrayList<albums> albumsList;
        CustomAdapter customAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            if (savedInstanceState != null) {
                albumsList = savedInstanceState.getParcelableArrayList("albumsList");
            }
            else {
                albumsList = new ArrayList<>();
                albumsList.add(new albums("Midnights", "44 min", "2022", "13 songs", "11 awards won", R.drawable.midnights,0));
                albumsList.add(new albums("Evermore", "60 min", "2020", "15 songs", "3 awards won", R.drawable.evermore,1));
                albumsList.add(new albums("Folklore", "63 min", "2020", "16 songs", "8 awards won", R.drawable.folk,2));
                albumsList.add(new albums("Lover", "61 min", "2019", "18 songs", "8 awards won", R.drawable.lover,3));
                albumsList.add(new albums("Reputation", "55 min", "2017", "15 songs", "7 awards won", R.drawable.rep,4));
                albumsList.add(new albums("1989", "68 min", "2014", "18 songs", "3 GRAMMY won", R.drawable.nine,5));
                albumsList.add(new albums("Red", "64 min", "2012", "16 songs", "9 awards won", R.drawable.red,6));
                albumsList.add(new albums("Speak Now", "67 min", "2010", "14 songs", "7 awards won", R.drawable.speaknow,7));
                albumsList.add(new albums("Fearless", "53 min", "2008", "13 songs", "10 awards won", R.drawable.fearless,8));
                albumsList.add(new albums("Debut: Taylor Swift", "53 min", "2006", "15 songs", "0 awards won", R.drawable.debut,9));
            }
            listView = findViewById(R.id.listID);
            CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, albumsList);
            customAdapter = adapter;
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity.this, i + " ", Toast.LENGTH_LONG).show();
                }
            });
        }
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putParcelableArrayList("albumsList", new ArrayList<>(albumsList));
        }
        @Override
        protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
           albumsList=savedInstanceState.getParcelableArrayList("albumsList");
        }
    }

