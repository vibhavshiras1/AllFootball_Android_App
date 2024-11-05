package com.example.football_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_info extends AppCompatActivity {

    private TextView pro_name,pro_email,pro_club,pro_team,pro_player,goHome;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ProgressDialog progressDialog1;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        pro_name = (TextView) findViewById(R.id.profile_name);
        pro_email = (TextView) findViewById(R.id.profile_email);
        pro_club = (TextView) findViewById(R.id.profile_club);
        pro_team = (TextView) findViewById(R.id.profile_team);
        pro_player = (TextView) findViewById(R.id.profile_player);
        progressDialog1 = new ProgressDialog(this);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        progressDialog1.setMessage("Just a moment..");
        progressDialog1.show();

        button = findViewById(R.id.logOut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(User_info.this,MainActivity.class);
                startActivity(intent5);
            }
        });

        goHome = findViewById(R.id.hometv);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_intent = new Intent(User_info.this,FootballActivity.class);
                startActivity(home_intent);
            }
        });



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);

                pro_name.setText("Username : " + userProfile.getUserName());
                pro_email.setText("Email-ID : " + userProfile.getUserEmail());
                pro_club.setText("Favourite Club : " + userProfile.getUserClub());
                pro_team.setText("Favourite National Team : " + userProfile.getUserTeam());
                pro_player.setText("Favourite Player : " + userProfile.getUserPlayer());
                /*Intent intent = new Intent(User_info.this,ProfileFragment.class);
                intent.putExtra("name1",userProfile.getUserName());
                intent.putExtra("email11",userProfile.getUserEmail());
                intent.putExtra("club1",userProfile.getUserClub());
                intent.putExtra("team1",userProfile.getUserTeam());
                intent.putExtra("player1",userProfile.getUserPlayer());
                intent.putExtra("flag",1);
                startActivity(intent);*/
                progressDialog1.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(User_info.this,error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}