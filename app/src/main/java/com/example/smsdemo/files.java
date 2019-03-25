package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class files extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] files=
            {"1.hello","2.goodbye","3.goodmorning"};
    private ListView listView;

    private String text;
    private String[] data=new String[10];
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        Intent t=getIntent();
        text=t.getStringExtra("dataname");
        data=t.getStringArrayExtra("data");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(files.this,android.R.layout.simple_list_item_1,files);
        listView=(ListView)findViewById(R.id.listfiles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void bsend2(View view){
        Intent intent=new Intent(files.this,sending.class);
        Bundle bundle = new Bundle() ;
        bundle.putInt("type",1);
        //finish();
        startActivity(intent);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        //String text = listView.getItemAtPosition(position)+"";

        Intent intent=new Intent(files.this,message.class);
        //finish();
        Bundle bundle = new Bundle() ;
        bundle.putInt("type",(int)id);
        bundle.putString("dataname",text);
        bundle.putSerializable("data",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
