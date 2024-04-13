package com.example.project;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
    public class CustomAdapter extends ArrayAdapter<albums> {
        List<albums> albumList;
        Context context;
        int xmlResource;
        float rating = 0;

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<albums> objects) {
            super(context, resource, objects);
            xmlResource = resource;
            this.context = context;
            albumList = objects;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //return super.getView(position, convertView, parent);\
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = layoutInflater.inflate(xmlResource,null);
            RatingBar ratingBar = adapterLayout.findViewById(R.id.ratingBar);
            TextView name = adapterLayout.findViewById(R.id.albumName);
            Button remove = adapterLayout.findViewById(R.id.removeButton);
            ImageView image = adapterLayout.findViewById(R.id.imageView);
            TextView year = adapterLayout.findViewById(R.id.year);
            TextView songnum = adapterLayout.findViewById(R.id.numberOfSongs);
            TextView duration = adapterLayout.findViewById(R.id.duration);
            TextView awards = adapterLayout.findViewById(R.id.AwardsWon);
            Switch awardSwitch = adapterLayout.findViewById(R.id.awardSwitch);
            TextView ratingText = adapterLayout.findViewById(R.id.ratingText);

            int pos =  albumList.get(position).getNum();
            setBackgroundColor(adapterLayout, pos,remove);

            remove.setText("REMOVE");
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    albumList.remove(position);
                    notifyDataSetChanged();
                }
            });
            name.setText(albumList.get(position).getName()+" ");
            image.setImageResource(albumList.get(position).getimgSource());
            //ratingBar.setRating(albumList.get(position).getRating());
            ratingText.setText(String.valueOf(albumList.get(position).getRating()));
            ratingBar.setRating(albumList.get(position).getRating());
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    rating=albumList.get(position).setRating(rating);
                    ratingText.setText(String.valueOf(rating));
                    Log.d("check", "onRatingChanged: "+rating);
                }
            });
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                year.setText(albumList.get(position).getYear()+" ");
                duration.setText(albumList.get(position).getDuration()+" ");
                songnum.setText(albumList.get(position).getNumberOfSongs()+" ");
                awardSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) {
                            awards.setText(albumList.get(position).getAwardsWon() + " ");
                        }
                        if(!isChecked) {
                            awards.setText("Switch to see awards won");
                        }
                    }
                });

            }
            return adapterLayout;
        }

        public void setBackgroundColor(View view, int pos,Button button){
            switch (pos) {
                case 0:
                    view.setBackgroundColor(Color.rgb(173,216,230));
                    button.setBackgroundColor(Color.rgb(59, 80, 112));
                    break;
                case 1:
                    view.setBackgroundColor(Color.rgb(254,216,177));
                    button.setBackgroundColor(Color.rgb(179, 115, 27));
                    break;
                case 2:
                    view.setBackgroundColor(Color.rgb(211,211,211));
                    button.setBackgroundColor(Color.rgb(71, 70, 69));
                    break;
                case 3:
                    view.setBackgroundColor(Color.rgb(250,218,221));
                    button.setBackgroundColor(Color.rgb(110, 43, 72));
                    break;
                case 4:
                    view.setBackgroundColor(Color.rgb(211,211,211));
                    button.setBackgroundColor(Color.rgb(71, 70, 69));
                    break;
                case 5:
                    view.setBackgroundColor(Color.rgb(173,216,230));
                    button.setBackgroundColor(Color.rgb(59, 80, 112));
                    break;
                case 6:
                    view.setBackgroundColor(Color.rgb(250,152,158));
                    button.setBackgroundColor(Color.rgb(105, 48, 48));
                    break;
                case 7:
                 view.setBackgroundColor(Color.rgb(230,230,250));
                    button.setBackgroundColor(Color.rgb(75, 18, 79));
                    break;
                case 8:
                   view.setBackgroundColor(Color.rgb(255, 255, 237));
                    button.setBackgroundColor(Color.rgb(145, 122, 17));
                    break;
                case 9:
                   view.setBackgroundColor(Color.rgb(229,248,229));
                   button.setBackgroundColor(Color.rgb(18, 59, 22));
                    break;
                default:
                   view.setBackgroundColor(Color.TRANSPARENT);
                    break;
            }
        }
    }

