package com.example.football_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView register_link;
    private EditText login_user;
    private EditText login_password;
    private Button login_btn1;
    private FirebaseAuth firebaseAuth1;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_user = findViewById(R.id.username);
        login_password = findViewById(R.id.password);
        login_btn1 = findViewById(R.id.login_btn);
        firebaseAuth1 = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        register_link = findViewById(R.id.reg_link);
        register_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,Registration_acitivity.class);
                startActivity(i1);

            }
        });

        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_text = login_user.getText().toString();
                String password_text = login_password.getText().toString();

                progressDialog.setMessage("Just a moment..");
                progressDialog.show();

                firebaseAuth1.signInWithEmailAndPassword(user_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Intent home_intent = new Intent(MainActivity.this,FootballActivity.class);
                            startActivity(home_intent);
                            Toast.makeText(MainActivity.this,"Login Successful!!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this,"Login Failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}