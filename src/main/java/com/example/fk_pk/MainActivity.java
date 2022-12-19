package com.example.fk_pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText f2,f3,f4,f5,f9;
    Button button;

    patient_dbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        f9=findViewById(R.id.f9);

        db=new patient_dbHelper(this);

    }
    public void op(View view)
    {
        String nm=f2.getText().toString();
        String em=f3.getText().toString();
        String ph=f4.getText().toString();
        String ad=f5.getText().toString();
        String pa=f9.getText().toString();


        boolean b=db.register(nm,em,ph,ad,pa);
        if(b==false)
        {
            Toast.makeText(this, "Can't Register", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Thanks For Register", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,chat.class);
            startActivity(i);
        }


    }


}
