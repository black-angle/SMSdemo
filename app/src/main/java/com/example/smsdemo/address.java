package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;

public class address extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private String[] data=
            {"Group1","  StudentA","  StudentB","Group2","  StudentC"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        listView=(ListView)findViewById(R.id.listaddrss);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(address.this,android.R.layout.simple_list_item_1,data);
        //ListView listView=(ListView)findViewById(R.id.listaddrss);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void bnext(View view){
        Intent intent=new Intent(address.this,message.class);
        //finish();
        startActivity(intent);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        String text = listView.getItemAtPosition(position)+"";

        Intent intent=new Intent(address.this,message.class);
        //finish();
        Bundle bundle = new Bundle() ;
        bundle.putString("dataname",text);
        if(text.equals("Group1")){
            bundle.putSerializable("data",new String[]{"StudentA","StudentB"});
        }
        else if(text.equals("Group2")){
            bundle.putSerializable("data",new String[]{"StudentC"});
        }
        else {
            bundle.putSerializable("data",new String[]{text});
        }
        intent.putExtras(bundle);
        startActivity(intent);
        /*
        String text = listView.getItemAtPosition(position) + "";// 指定位置的内容
        Toast.makeText(this, "positon=" + position + "text" + text,
                Toast.LENGTH_LONG).show();
        */
    }
}
