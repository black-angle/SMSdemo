package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] data=
            {"To: Group1 successfully","To: StudentA successfully","To: StudentB successfully","To: Group2 successfully","To: StudentC successfully"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        //ListView listView=(ListView)findViewById(R.id.listsent);
        //listView.setAdapter(adapter);
    }

    public void bnew(View view){
        //Toast.makeText(this, "Hello",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity.this,address.class);
        //finish();
        startActivity(intent);
    }
}
