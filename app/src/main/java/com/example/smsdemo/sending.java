package com.example.smsdemo;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class sending extends AppCompatActivity {

    private String[] data=new String[10];
            //{"StudentA                                        successfully","StudentB                                        successfully"};
    private String text;
    private String mes;
    private TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);

        Intent tv=getIntent();
        data=tv.getStringArrayExtra("data");
        text=tv.getStringExtra("dataname");
        mes=tv.getStringExtra("mes");
        //Toast.makeText(this, mes,Toast.LENGTH_LONG).show();
        //String t=tv.getStringExtra("data");
        //data[0]=t;//tv.getStringExtra("data");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(sending.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.listsending);
        listView.setAdapter(adapter);


    }

    //getPrivilege(Manifest.permission.SEND_SMS)


    private void getPrivilege(String permission) {
        //检测当前版本是否大于6.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            /**
             * 检测运行时权限是否已经得到授权
             * ContextCompat.checkSelfPermission();第二个参数传递一个权限，检测这个权限是否已经授权
             * 方法返回值为PackageManager.PERMISSION_DENIED或者PackageManager.PERMISSION_GRANTED
             */
            if (ContextCompat.checkSelfPermission(getApplicationContext(), permission)
                    != PackageManager.PERMISSION_GRANTED) {
                /**
                 * 没有得到授权去请求得到授权
                 * 参数一：上下文
                 * 参数二：要申请权限的数组
                 * 参数三：请求码，用于回调
                 * */
                ActivityCompat.requestPermissions(sending.this, new String[]{permission}, 1);
            }
//            else{
//                //得到授权，直接进行要做的操作
//            }
        }
    }

    public String renum(String name){
        if(name.equals("StudentA")){
            return "10086";
        }
        else if(name.equals("StudentB")){
            return "10087";
        }
        else if(name.equals("StudentC")){
            //return "13101294887";
            //return "17754927476";
            return "17725023950";
        }
        return "000";
    }

    public void sendmes(String num,String mess){
        SmsManager smr=SmsManager.getDefault();
        PendingIntent pi = PendingIntent.getActivity(sending.this, 0, new Intent(), 0);
        //send message
        smr.sendTextMessage(num, null, mess, pi, null);
    }

    public String getmess(String name,String phone,String nmess){
        int l=nmess.length();
        //Toast.makeText(this,""+l ,Toast.LENGTH_LONG).show();
        String res="";
        for(int i=0;i<l;i++){
            //Toast.makeText(this,nmess.charAt(i) ,Toast.LENGTH_LONG).show();
            if(nmess.charAt(i)=='%'){
                //Toast.makeText(this, "0001"+i,Toast.LENGTH_LONG).show();
                if(i+5>=l){
                    res+=nmess.charAt(i);
                }
                else if(nmess.charAt(i+1)=='n'&&nmess.charAt(i+2)=='a'&&nmess.charAt(i+3)=='m'&&nmess.charAt(i+4)=='e'&&nmess.charAt(i+5)=='%'){
                    i+=5;
                    res+=name;
                }
                else if(i+6==l){
                    res+=nmess.charAt(i);
                }
                else if(nmess.charAt(i+1)=='p'&&nmess.charAt(i+2)=='h'&&nmess.charAt(i+3)=='o'&&nmess.charAt(i+4)=='n'&&nmess.charAt(i+5)=='e'&&nmess.charAt(i+6)=='%'){
                    i+=6;
                    res+=phone;
                }
                else{
                    res+=nmess.charAt(i);
                }
            }
            else{
                res+=nmess.charAt(i);
            }

        }
        return res;
    }


    public void  bssend(View view){
        //mes text data
        if(text.equals("Group1")){
            //bundle.putString("dataname",text);bundle.putSerializable("data",new String[]{"StudentA","StudentB"});
            for(int i=0;i<2;i++){
                sendmes(renum(data[i]),getmess(data[i],renum(data[i]),mes));
                //Toast.makeText(this, getmess(data[i],renum(data[i]),mes),Toast.LENGTH_LONG).show();
                //String tem=getmess(data[i],renum(data[i]),mes);
                //Toast.makeText(this, tem,Toast.LENGTH_LONG).show();
            }
        }
        else if(text.equals("Group2")){
            //bundle.putString("dataname",text);bundle.putSerializable("data",new String[]{"StudentC"});
            for(int i=0;i<1;i++){
                sendmes(renum(data[i]),getmess(data[i],renum(data[i]),mes));
            }
        }
        else if(text.charAt(7)=='A'){
            //Toast.makeText(this, "AAA",Toast.LENGTH_LONG).show();
            //bundle.putString("dataname","StudentA");bundle.putSerializable("data",new String[]{"StudentA"});
            for(int i=0;i<1;i++){
                sendmes(renum(data[i]),getmess(data[i],renum(data[i]),mes));
            }
        }
        else if(text.charAt(7)=='B'){
            //bundle.putString("dataname","StudentB");bundle.putSerializable("data",new String[]{"StudentB"});
            for(int i=0;i<1;i++){
                sendmes(renum(data[i]),getmess(data[i],renum(data[i]),mes));
            }
        }
        else if(text.charAt(7)=='C'){
           // bundle.putString("dataname","StudentC");bundle.putSerializable("data",new String[]{"StudentC"});
            for(int i=0;i<1;i++){
                sendmes(renum(data[i]),getmess(data[i],renum(data[i]),mes));
            }
        }
        Toast.makeText(sending.this, "SMS sending completed."
                , Toast.LENGTH_SHORT).show();

        tt=(TextView) findViewById(R.id.textView5);
        tt.setText("Completed");
        //String tt="hello";
        //SmsManager smr=SmsManager.getDefault();
        //PendingIntent pi = PendingIntent.getActivity(sending.this, 0, new Intent(), 0);
        //
        //smr.sendTextMessage("13101294887", null, tt, pi, null);
    }

    public void bback(View view){
/*
        String tt="hello";
        SmsManager smr=SmsManager.getDefault();
        PendingIntent pi = PendingIntent.getActivity(
                sending.this, 0, new Intent(), 0);
        // send message
        smr.sendTextMessage("13101294887", null, tt, pi, null);
*/
        /*getPrivilege(Manifest.permission.SEND_SMS);
        String tt="hello";
        SmsManager smr=SmsManager.getDefault();
        smr.sendTextMessage("10086",null,tt,null,null);
        */
        /*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if(ContextCompat.checkSelfPermission(sending.this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED){

                Log.e("TAG", "");
                ActivityCompat.requestPermissions(sending.this,new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
                Log.e("TAG", "");
            }else{
                //
                Log.e("TAG", "");
                String tt="hello";
                SmsManager smr=SmsManager.getDefault();
                //smr.sendTextMessage("10086",null,tt,null,null);
            }
        }
*/
        //getPrivilege(Manifest.permission.SEND_SMS);
        /*int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS );
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.e("TAG", "");
        } else {
            Log.e("TAG", "");
        }*/

        Intent intent=new Intent(sending.this,MainActivity.class);
        //finish();

        startActivity(intent);

    }
}
