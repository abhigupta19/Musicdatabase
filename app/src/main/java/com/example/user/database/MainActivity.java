package com.example.user.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     EditText e;
     Spinner s;
     Button b;
  DatabaseReference d;
  ListView l1;
  List<Artist>artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(EditText)findViewById(R.id.editText);
        s=(Spinner)findViewById(R.id.spinner);
        b=(Button)findViewById(R.id.button2);
        l1=(ListView)findViewById(R.id.ss);
        d= FirebaseDatabase.getInstance().getReference("artist");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ari();
            }
        });
        artistList=new ArrayList<>();
    }
    private void ari()
    {
        String name=e.getText().toString();
        String gener=s.getSelectedItem().toString();
        String id=d.getKey().toString();
         Artist a=new Artist(id,name,gener);
         d.child(id).setValue(a);

    }

    @Override
    protected void onStart() {
        super.onStart();
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot d:dataSnapshot.getChildren()) {
                    Artist artist = d.getValue(Artist.class);
                    artistList.add(artist);
                }
                Artistlist adap=new Artistlist(MainActivity.this, artistList);
                l1.setAdapter(adap);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
