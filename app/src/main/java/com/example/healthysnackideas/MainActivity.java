package com.example.healthysnackideas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    int [] snacks = {
            R.drawable.snack1,
            R.drawable.snack2,
            R.drawable.snack3,
            R.drawable.snack4,
            R.drawable.snack5
    };
    String [] snackNames = {
            "Strawberry Shake",
            "Beans",
            "Almonds",
            "Apricots",
            "Cherries"
    };

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        pic = findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 Snackbar.make(view,
                        "Selected Snack: " + snackNames[position],
                        Snackbar.LENGTH_LONG).show();

                pic.setImageResource(snacks[position]);
            }
        });
    }

    private class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return snacks.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView pic = new ImageView(context);
            pic.setImageResource(snacks[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
//            pic.setLayoutParams(new GridView.LayoutParams(400, 150));
            return pic;
        }
    }
}
