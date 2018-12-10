package ntub.std.myapplication;

import android.media.Image;
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
    private ListView lis1;
    private TextView txt1;

    String friends[] = new String[]{"friend1", "friend2", "friend3"};
    int[] img = {R.drawable.a1, R.drawable.a2, R.drawable.a3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lis1 = findViewById(R.id.lis1);
        txt1 = findViewById(R.id.txt1);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, friends);
        lis1.setAdapter(adapter);
        lis1.setAdapter(new Myadapter());

        lis1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt1.setText(friends[position]);
            }
        });
		
		lis1.setSelector(R.drawable.green);
		
		lis1.setTextFilterEnabled(true);

    }

    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return friends.length;
        }

        @Override
        public Object getItem(int position) {
            return friends[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.mylayout, null);
            ImageView img5 = findViewById(R.id.img5);
            TextView txt5 = findViewById(R.id.txt5);

            img5.setImageResource(img[position]);
            txt5.setText(friends[position]);
            return convertView;
        }
    }
}
