package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Intent intent = getIntent();
        //从Intent当中根据key取得value
        String value = intent.getStringExtra("StoM");
        if(value != "FromEntry"){
           Button button = (Button)findViewById(R.id.radio_button1);
            button.setVisibility(View.GONE);
            button = (Button)findViewById(R.id.radio_button2);
            button.setVisibility(View.GONE);
        }

    }
}
