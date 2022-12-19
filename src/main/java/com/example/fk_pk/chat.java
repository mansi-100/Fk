package com.example.fk_pk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chat extends AppCompatActivity {

   patient_dbHelper p;
    EditText ep1,ep2,ep3;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        
        bt=findViewById(R.id.bt);
        ep1=findViewById(R.id.ep1);
        ep2=findViewById(R.id.ep2);
        ep3=findViewById(R.id.ep3);
        p=new patient_dbHelper(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chat.this, "dn", Toast.LENGTH_SHORT).show();
                String s1,s2,s3;
                s1=ep1.getText().toString();
                s2=ep2.getText().toString();
                s3=ep3.getText().toString();
//                int i=Integer.parseInt(s3);

                boolean b=p.register(s1,s2,s3);

                if(b==false)
                {
                    Toast.makeText(chat.this, "Can't Register", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(chat.this, "Thanks For Register", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}