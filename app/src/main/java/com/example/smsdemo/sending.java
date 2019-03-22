package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class sending extends AppCompatActivity {

    private String[] data=new String[10];
            //{"StudentA                                        successfully","StudentB                                        successfully"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);

        Intent tv=getIntent();
        data=tv.getStringArrayExtra("data");
        //String t=tv.getStringExtra("data");
        //data[0]=t;//tv.getStringExtra("data");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(sending.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.listsending);
        listView.setAdapter(adapter);
    }

    public void bback(View view){
        Intent intent=new Intent(sending.this,MainActivity.class);
        //finish();
        startActivity(intent);
    }
}
