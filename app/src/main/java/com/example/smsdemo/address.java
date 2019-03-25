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
            {"Group1","  StudentA                 10086","  StudentB                 10087","Group2","  StudentC              13101294887"};


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
        bundle.putInt("type",4);
        //bundle.putString("dataname",text);
        if(text.equals("Group1")){
            bundle.putString("dataname",text);bundle.putSerializable("data",new String[]{"StudentA","StudentB"});
        }
        else if(text.equals("Group2")){
            bundle.putString("dataname",text);bundle.putSerializable("data",new String[]{"StudentC"});
        }
        else if(text.charAt(9)=='A'){
            //Toast.makeText(this, "AAA",Toast.LENGTH_LONG).show();
            bundle.putString("dataname","StudentA");bundle.putSerializable("data",new String[]{"StudentA"});
        }
        else if(text.charAt(9)=='B'){
            bundle.putString("dataname","StudentB");bundle.putSerializable("data",new String[]{"StudentB"});
        }
        else if(text.charAt(9)=='C'){
            bundle.putString("dataname","StudentC");bundle.putSerializable("data",new String[]{"StudentC"});
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
