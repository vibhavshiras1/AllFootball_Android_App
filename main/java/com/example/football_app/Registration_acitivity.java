package com.example.football_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_acitivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText username2;
    private EditText email;
    private EditText password2;
    private Button reg_link;
    private FirebaseAuth firebaseAuth;
    private Spinner spin1, spin2;
    private String[] football_clubs = {"-Select Football Club-","Real Madrid","Barcelona","Man United","Tottenham","Chelsea","Man City","Juventus","Arsenal","Liverpool"};
    private String[] national_teams = {"-Select National Team-","England","Portugal","Brazil","Argentina","France","Belgium","Germany","Spain"};
    private EditText player;
    String club,national_team,user_email,user_password,user_name,user_player;

    @Override
    public void onBackPressed() {
        Intent reg_intent = new Intent(this,MainActivity.class);
        startActivity(reg_intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_acitivity);

        username2 = findViewById(R.id.reg_username);
        email = findViewById(R.id.reg_email);
        password2 = findViewById(R.id.reg_password);
        reg_link = findViewById(R.id.reg_btn);
        player = findViewById(R.id.footballPlayer);
        spin1 = (Spinner) findViewById(R.id.spinner1);
        spin2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,football_clubs);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,national_teams);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        spin2.setAdapter(adapter2);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);



        firebaseAuth = FirebaseAuth.getInstance();

        reg_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_email = email.getText().toString().trim();
                user_password = password2.getText().toString().trim();
                user_name = username2.getText().toString().trim();
                user_player = player.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            sendUserData();
                            Toast.makeText(Registration_acitivity.this,"You have successfully registered!",Toast.LENGTH_SHORT).show();
                            Intent i1 = new Intent(Registration_acitivity.this,MainActivity.class);
                            Toast.makeText(Registration_acitivity.this,"Please login with the credentials.",Toast.LENGTH_LONG).show();
                            startActivity(i1);
                        }
                        else{
                            Toast.makeText(Registration_acitivity.this,"Something went wrong.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(user_name,user_email,club,national_team,user_player);
        myref.setValue(userProfile);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spin1 = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;
        if(spin1.getId()==R.id.spinner1){
            //Toast.makeText(this,"Selected football club : "+football_clubs[position],Toast.LENGTH_SHORT).show();
            club = football_clubs[position];
        }
        if(spin2.getId()==R.id.spinner2){
            //Toast.makeText(this,"Selected national team : "+national_teams[position],Toast.LENGTH_SHORT).show();
            national_team = national_teams[position];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}