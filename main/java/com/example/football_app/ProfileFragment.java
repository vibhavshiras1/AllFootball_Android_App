package com.example.football_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {


    public ProfileFragment(){
    }

    private TextView pro_name,pro_email,pro_club,pro_team,pro_player;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile,container,false);

        /*pro_name = (TextView) rootView.findViewById(R.id.profile_name);
        pro_email = (TextView) rootView.findViewById(R.id.profile_email);
        pro_club = (TextView) rootView.findViewById(R.id.profile_club);
        pro_team = (TextView) rootView.findViewById(R.id.profile_team);
        pro_player = (TextView) rootView.findViewById(R.id.profile_player);

        //pro_name.setText("Username : " + "Vibhav Shiras");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String uid = user.getUid();

        DatabaseReference databaseReference = firebaseDatabase.getReference("https://footballapp-19ca9-default-rtdb.firebaseio.com/").child(uid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String name = (String) snapshot.child("userName").getValue();
                pro_name.setText("Name : " + name);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(),error.getCode(),Toast.LENGTH_SHORT).show();
            }
        });*/

        Intent intent;

            intent = new Intent(getActivity(), User_info.class);
            startActivity(intent);





        return rootView;
    }



    //@Override
    /*public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pro_name = (TextView) getView().findViewById(R.id.profile_name);
        pro_email = (TextView) getView().findViewById(R.id.profile_email);
        pro_club = (TextView) getView().findViewById(R.id.profile_club);
        pro_team = (TextView) getView().findViewById(R.id.profile_team);
        pro_player = (TextView) getView().findViewById(R.id.profile_player);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);
                pro_name.setText("Username : " + userProfile.getUserName());
                pro_email.setText("Email-ID : " + userProfile.getUserEmail());
                pro_club.setText("Favourite Club : " + userProfile.getUserClub());
                pro_team.setText("Favourite National Team : " + userProfile.getUserTeam());
                pro_player.setText("Favourite Player : " + userProfile.getUserPlayer());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(),error.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}
