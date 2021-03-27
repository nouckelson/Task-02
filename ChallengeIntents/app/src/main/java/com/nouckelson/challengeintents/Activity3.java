package com.nouckelson.challengeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity implements  View.OnClickListener {
    ImageView imageViewContact,imageViewPhone,imageViewWeb,imageViewLocation;
    Button btnContact;
    Intent data;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        imageViewContact=findViewById(R.id.imageViewContact);
        imageViewPhone=findViewById(R.id.imageViewPhone);
        imageViewWeb=findViewById(R.id.imageViewWeb);
        imageViewLocation=findViewById(R.id.imageViewLocation);

        imageViewContact.setOnClickListener(this);
        imageViewPhone.setOnClickListener(this);
        imageViewWeb.setOnClickListener(this);
        imageViewLocation.setOnClickListener(this);

        btnContact=findViewById(R.id.btnContact);
        btnContact.setOnClickListener(this);


        data=getIntent();
        setMotion(data);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageViewPhone:
                Intent number=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+data.getStringExtra("number")));
                startActivity(number);
                break;
            case R.id.imageViewWeb:
                Uri uri = Uri.parse(data.getStringExtra("web"));
                if (!data.getStringExtra("web").startsWith("http://") && !data.getStringExtra("web").startsWith("https://")) {
                    uri = Uri.parse("http://" + data.getStringExtra("web"));
                }
                Intent web = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(web);
                break;
            case R.id.imageViewLocation:
                Intent location=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+data.getStringExtra("location")));
                startActivity(location);
                break;
            case R.id.btnContact:
                finish();
                break;
        }
    }


    public void setMotion(Intent d){
        String  motion=d.getStringExtra("resource");
        switch (motion){
            case "1":
                imageViewContact.setImageResource(R.drawable.sentiment_satisfied);
                break;
            case "2":
                imageViewContact.setImageResource(R.drawable.sentiment_dissatisfied);
                break;
            case "3":
                imageViewContact.setImageResource(R.drawable.sentiment_very_dissatisfied);
                break;
        }
    }


}