package ntub.std.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt1, ed1, ed2, ed3;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        SharedPreferences spf = getSharedPreferences("sorry", MODE_PRIVATE);
        String name = spf.getString("name", "");
        final String gr = spf.getString("gr", "");
        final int it = spf.getInt("it", 0);


        if(name.compareTo("") == 0 || gr.compareTo("") == 0 || it == 0) {
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("HALLO")
                   .setMessage("you need to set your name")
                   .show();
        } else {
            Toast.makeText(MainActivity.this, "yes! toll! toll!", Toast.LENGTH_LONG).show();
            ed1.setText(name);
            ed2.setText(gr);
            ed3.setText(String.valueOf(it));
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed1.getText().toString();
                String gr = ed2.getText().toString();
                int it = Integer.parseInt(ed3.getText().toString());
                SharedPreferences spf = getSharedPreferences("sorry", MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putString("name", a).commit();
                editor.putString("gr", gr).commit();
                editor.putInt("it", it).commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences("sorry", MODE_PRIVATE)
                        .edit()
                        .clear()
                        .commit();

            }
        });


    }
}
