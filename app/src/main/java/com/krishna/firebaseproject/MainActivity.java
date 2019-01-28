package com.krishna.firebaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.krishna.firebaseproject.module.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //view objects
    EditText edtName,edtDesignation;
    Button buttonAddArtist;

    //our database reference object
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("employee");

        //getting views
        edtName = (EditText) findViewById(R.id.edtName);
        edtDesignation = (EditText) findViewById(R.id.edtDesignation);

        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);

        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();
            }
        });
    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addArtist() {
        //getting the values to save
        String name = edtName.getText().toString().trim();
        String designation = edtDesignation.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Employee artist = new Employee(id, name, designation);

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again
            edtName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Employee added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}