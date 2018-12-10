package ntub.std.myapplication01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.Service;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn11, btn0, btnD;
    private TextView txt01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn01 = findViewById(R.id.btn1);
        btn02 = findViewById(R.id.btn2);
        btn03 = findViewById(R.id.btn3);
        btn04 = findViewById(R.id.btn4);
        btn05 = findViewById(R.id.btn5);
        btn06 = findViewById(R.id.btn6);
        btn07 = findViewById(R.id.btn7);
        btn08 = findViewById(R.id.btn8);
        btn09 = findViewById(R.id.btn9);
        btn11 = findViewById(R.id.btn11);
        btnD = findViewById(R.id.btnD);
        txt01 = findViewById(R.id.txt01);

        btn0.setOnClickListener(listener);
        btn01.setOnClickListener(listener);
        btn02.setOnClickListener(listener);
        btn03.setOnClickListener(listener);
        btn04.setOnClickListener(listener);
        btn05.setOnClickListener(listener);
        btn06.setOnClickListener(listener);
        btn07.setOnClickListener(listener);
        btn08.setOnClickListener(listener);
        btn09.setOnClickListener(listener);
        txt01.setText("");
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txt01.getText().toString();
                if(input.compareTo("0919") == 0){
                    Toast t = Toast.makeText(MainActivity.this, "沒錯", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();

                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("hello")
                            .setMessage("你錯了")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    setVibrate(1000);

                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                   finish(); /*關閉整個app*/
                                }
                            })
                            .show()
                    ;
                }

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = txt01.getText().length();
                txt01.setText(txt01.getText().toString().subSequence(0, len-1));
            }
        });


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn0:
                    txt01.setText(txt01.getText().toString() + "0");
                    break;
                case R.id.btn1:
                    txt01.setText(txt01.getText().toString() + "1");
                    break;
                case R.id.btn2:
                    txt01.setText(txt01.getText().toString() + "2");
                    break;
                case R.id.btn3:
                    txt01.setText(txt01.getText().toString() + "3");
                    break;
                case R.id.btn4:
                    txt01.setText(txt01.getText().toString() + "4");
                    break;
                case R.id.btn5:
                    txt01.setText(txt01.getText().toString() + "5");
                    break;
                case R.id.btn6:
                    txt01.setText(txt01.getText().toString() + "6");
                    break;
                case R.id.btn7:
                    txt01.setText(txt01.getText().toString() + "7");
                    break;
                case R.id.btn8:
                    txt01.setText(txt01.getText().toString() + "8");
                    break;
                case R.id.btn9:
                    txt01.setText(txt01.getText().toString() + "9");
                    break;

            }
        }
    };

    public void setVibrate(int time){
        Vibrator myVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        myVibrator.vibrate(time);
    }



}
