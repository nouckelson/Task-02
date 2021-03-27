package com.nouckelson.challengeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements  View.OnClickListener {
    EditText editName,editnumber,editWebAdress,editLocation;
    ImageView imageViewSatisfied,imageViewDissatisfied,imageViewVeryDissatisfied;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        editName=findViewById(R.id.editName);
        editnumber=findViewById(R.id.editnumber);
        editWebAdress=findViewById(R.id.editWebAdress);
        editLocation=findViewById(R.id.editLocation);

        imageViewSatisfied=findViewById(R.id.imageViewSatisfied);
        imageViewDissatisfied=findViewById(R.id.imageViewDissatisfied);
        imageViewVeryDissatisfied=findViewById(R.id.imageViewVeryDissatisfied);

        imageViewSatisfied.setOnClickListener(this);
        imageViewDissatisfied.setOnClickListener(this);
        imageViewVeryDissatisfied.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        String name=editName.getText().toString();
        String number=editnumber.getText().toString();
        String web=editWebAdress.getText().toString();
        String location=editLocation.getText().toString();
        if(name.isEmpty() || number.isEmpty() || web.isEmpty() || location.isEmpty()){
            Toast.makeText(Activity2.this,"Fields should be fill!",Toast.LENGTH_LONG).show();
        }else {
            switch (id) {
                case R.id.imageViewDissatisfied:
                    save(name, number, web, location,"2");
                    break;
                case R.id.imageViewVeryDissatisfied:
                    save(name, number, web, location,"3");
                    break;
                default:
                    save(name, number, web, location,"1");
                    break;
            }
        }
    }
    public  void save(String name,String number,String web,String location,String motion){
        Intent intent=new Intent(Activity2.this,Activity3.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        intent.putExtra("web",web);
        intent.putExtra("location",location);
        intent.putExtra("resource",motion);
        startActivity(intent);
    }
}