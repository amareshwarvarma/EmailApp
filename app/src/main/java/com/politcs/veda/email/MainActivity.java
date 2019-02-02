package com.politcs.veda.email;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText message,count;
    Button send;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editTextTo=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText1);
        count=(EditText)findViewById(R.id.editText3);

        send=(Button)findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
        /*send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PackageManager pm=getPackageManager();

                //String to=editTextTo.getText().toString();
                String message_str=message.getText().toString();
                String count_str=count.getText().toString();
                //String messages="";
                n = Integer.valueOf(count_str);
                //for(int i=0;i<n;i++) {
                    //messages=messages+message_str+"\n";
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    //String text = "YOUR TEXT HERE";

                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");

                    waIntent.putExtra(Intent.EXTRA_TEXT, message_str);
                    Intent.createChooser(waIntent, "Share with");
                    for (int i=0;i<n;i++) {
                        startActivity(waIntent);
                    }

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(MainActivity.this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
*/
}
