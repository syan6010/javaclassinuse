package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtPhone;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhone = findViewById(R.id.txtPhone);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);
        button3 = findViewById(R.id.button4);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);

    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button2:
                    txtPhone.setText(txtPhone.getText().toString() + "1");
                    break;
                case R.id.button3:
                    txtPhone.setText(txtPhone.getText().toString() + "2");
                    break;
                case R.id.button4:
                    txtPhone.setText(txtPhone.getText().toString() + "3");
                    break;
            }
        }
    };



}