package ntub.std.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt1, txt2;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("hello", "OnCreate: ");
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                it.putExtra("name", txt1.getText().toString());
                it.putExtra("number", Integer.parseInt(txt2.getText().toString()));
                startActivity(it);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("hello1", "OnPause");
    }

}
