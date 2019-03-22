package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class message extends AppCompatActivity {

    private String text;
    private String[] data=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent t=getIntent();
        TextView tv=(TextView) findViewById(R.id.textView3);
        TextView t2=(TextView) findViewById(R.id.editText2);
        text=t.getStringExtra("dataname");
        data=t.getStringArrayExtra("data");
        tv.setText("to "+text+" with");
        t2.setText("hello");
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
        bundle.putSerializable("data",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
