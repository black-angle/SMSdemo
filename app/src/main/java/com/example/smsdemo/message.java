package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class message extends AppCompatActivity {

    private String text;
    private String[] data=new String[10];
    private int type;
    private TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent t=getIntent();
        TextView tv=(TextView) findViewById(R.id.textView3);
        t2=(TextView) findViewById(R.id.editText2);

        text=t.getStringExtra("dataname");
        data=t.getStringArrayExtra("data");
        type=t.getIntExtra("type",0);
        tv.setText("to "+text+" with");
        if(type==0){
            t2.setText("Hello %name%.");
        }
        else if(type==1){
            t2.setText("Goodbye %name%.");
        }
        else if(type==2){
            t2.setText("Good monring %phone%.");
        }
        else{
            t2.setText("");
        }
        //t2.setText("hello");
    }

    public void bfile(View view){
        Intent intent=new Intent(message.this,files.class);
        //finish();
        Bundle bundle = new Bundle() ;
        //bundle.putInt("type",2);
        bundle.putString("dataname",text);
        bundle.putSerializable("data",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void bsend(View view){
        Intent intent=new Intent(message.this,sending.class);
        //finish();
        Bundle bundle = new Bundle() ;
        bundle.putString("dataname",text);
        bundle.putSerializable("data",data);
        bundle.putString("mes",t2.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
