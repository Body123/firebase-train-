package com.example.firebase_train;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name,age,phone;
    Button upload;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference = FirebaseDatabase.getInstance().getReference("Database").child("users");
        name=findViewById(R.id.nametxt);
        age=findViewById(R.id.agetxt);
        phone=findViewById(R.id.phonetxt);
        upload=findViewById(R.id.uploadbtn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(name.getText().toString())) {
                    Model model = new Model(name.getText().toString(), age.getText().toString(), phone.getText().toString());
                    reference.push().setValue(model);
                }else{
                    Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
