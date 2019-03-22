package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class message extends AppCompatActivity {

    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent t=getIntent();
        TextView tv=(TextView) findViewById(R.id.textView3);
        text=t.getStringExtra("data");
        tv.setText("to "+text+" with");
    }

    public void bfile(View view){
        Intent intent=new Intent(message.this,files.class);
        //finish();

        startActivity(intent);
    }

    public void bsend(View view){
        Intent intent=new Intent(message.this,sending.class);
        //finish();
        Bundle bundle = new Bundle() ;
        intent.putExtra("data",text);
        startActivity(intent);
    }
}
