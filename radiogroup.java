package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox chk1, chk2, chk3;
    private TextView txt1, txt2;
    private RadioGroup rad1;
    private RadioButton rao1, rao2, rao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        rad1 = findViewById(R.id.rad1);
        rao1 = findViewById(R.id.rao1);
        rao2 = findViewById(R.id.rao2);
        rao3 = findViewById(R.id.rao3);

        chk1.setOnCheckedChangeListener(listener);
        chk2.setOnCheckedChangeListener(listener);
        chk3.setOnCheckedChangeListener(listener);

        rad1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton btn = findViewById(checkedId);
                txt2.setText(btn.getText().toString());
            }
        });

    }

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int amount = 0;
            String txt = "";
            if(chk1.isChecked()) {
                txt += chk1.getText().toString() + " ";
                amount ++;
            }
            if(chk2.isChecked()) {
                txt += chk2.getText().toString() + " ";
                amount ++;
            }
            if(chk3.isChecked()) {
                txt += chk3.getText().toString() + " ";
                amount ++;
            }
            txt1.setText("you pick   " + txt + "total is" + amount);

        }
    };

}
