package net.androidbootcamp.personalphotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView fam;

    String [] names = {"Paulette", "Gregory and Chystelle", "Katera", "Michelle", "Damari", "Gordino", "Shay and Steve", "Shay"};
    Integer[] Family = {R.drawable.picture_1_mom, R.drawable.picture_2_sis, R.drawable.picture_3_kk, R.drawable.picture_4_shelly,
            R.drawable.picture_5_mari, R.drawable.picture_6_nat, R.drawable.picture_7_shay_steve, R.drawable.picture_8_shay};


    ImageView fPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView fam = (GridView) findViewById(R.id.gridView);
        final ImageView fPic = (ImageView) findViewById(R.id.imgLarge);
        fam.setAdapter(new ImageAdapter(this));
        fam.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "First Name: " + names [+ position], Toast.LENGTH_LONG).show();
                fPic.setImageResource(Family[position]);

            }
        });
    }


    public class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context c) {
            context = c;

        }

        @Override
        public int getCount() {
            return Family.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            fPic = new ImageView(context);
            fPic.setImageResource(Family[position]);
            fPic.setScaleType(ImageView.ScaleType.FIT_XY);
            fPic.setLayoutParams(new GridView.LayoutParams(330, 330));
            return fPic;

        }
    }
}


