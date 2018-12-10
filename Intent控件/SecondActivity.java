package ntub.std.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);

        Intent it = getIntent();

        String name = it.getStringExtra("name");
        int number = it.getIntExtra("number", 0);

        txt3.setText(name);
        txt4.setText(String.valueOf(number));

    }

}
