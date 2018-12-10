package ntub.std.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    private ImageView img1;
    int[] ImgIds = {
            R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6
    };
    int index1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        img1 = findViewById(R.id.img1);



        img1.setImageResource(ImgIds[index1]);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index1 == 0) {
                    index1 = ImgIds.length - 1;
                    img1.setImageResource(ImgIds[index1]);
                }else {
                    index1--;
                    img1.setImageResource(ImgIds[index1]);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index1 == ImgIds.length-1) {
                    index1 = 0;
                    img1.setImageResource(ImgIds[index1]);
                } else{
                    index1++;
                    img1.setImageResource(ImgIds[index1]);
                }
            }
        });

    }
}
