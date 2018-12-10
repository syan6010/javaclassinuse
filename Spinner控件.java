package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spn1;
    private TextView txt1;
    String[] options = new String[]{"籃球", "棒球", "足球"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spn1);
        txt1 = findViewById(R.id.txt1);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, options);
        ArrayAdapter<CharSequence> adapter1 =
                ArrayAdapter.createFromResource(MainActivity.this, R.array.sports, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn1.setAdapter(adapter);
        spn1.setAdapter(adapter1);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getSelectedItem().toString();
                //((TextView)view).getText().toString();
                //options[position];
                String selected1 = options[position];

                txt1.setText("you choose   " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
