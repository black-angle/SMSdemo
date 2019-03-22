package com.example.smsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class files extends AppCompatActivity {

    private String[] data=
            {"file1","file2","file3","file_hello","file_bye"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(files.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.listfiles);
        listView.setAdapter(adapter);
    }

    public void bsend2(View view){
        Intent intent=new Intent(files.this,sending.class);
        //finish();
        startActivity(intent);
    }
}
