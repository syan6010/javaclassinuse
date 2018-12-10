package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private TextView ed1;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ed1.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput("sorry.dat", MODE_PRIVATE);
                    PrintWriter pwr = new PrintWriter(fout);
                    pwr.print(data);
                    pwr.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput("sorry.dat");
                    Scanner sc = new Scanner(fin);
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        Log.d("btnLoad", "onclick" + line);
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
