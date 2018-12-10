package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private GridView gri1;
    private ImageView img1;
    int[] ImgIds = {
            R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gri1 = findViewById(R.id.gri1);
        img1 = findViewById(R.id.img1);

        gri1.setAdapter(new MyAdapter());
        gri1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                img1.setImageResource(ImgIds[position]);
            }
        });

    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ImgIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(MainActivity.this);
            iv.setImageResource(ImgIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new GridView.LayoutParams(300,200));
            return iv;
        }
    }

}
