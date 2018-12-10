package ntub.std.hellontub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lstView;
    String[] data = {
            "apple", "banana", "cat", "dog"
    };
    int[] imgIds = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.mbg
    };
    TextView txtChosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView = findViewById(R.id.lstView);
        txtChosen = findViewById(R.id.txtChosen);
        MyAdapter myAdapter = new MyAdapter();
        lstView.setAdapter(myAdapter);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtChosen.setText(data[position]);
            }
        });
        lstView.setSelector(R.color.mycolor);
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() { return data.length; }
        @Override
        public Object getItem(int position) { return data[position]; }
        @Override
        public long getItemId(int position) { return 0; }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.mylayout, null);
            ImageView iv = convertView.findViewById(R.id.imgShow);
            iv.setImageResource(imgIds[position]);
            TextView txt = convertView.findViewById(R.id.txtShow);
            txt.setText(data[position]);
            return convertView;
        }
    }
}
