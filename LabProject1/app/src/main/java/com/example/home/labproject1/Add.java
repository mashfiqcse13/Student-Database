package com.example.home.labproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by home on 6/5/2015.
 */

public class Add extends ActionBarActivity {

    EditText name,address,email,phone,instiution;
    Button save;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        name=(EditText)findViewById(R.id.etAddName);
        email=(EditText)findViewById(R.id.etAddEmail);
        address=(EditText)findViewById(R.id.etAddAddress);
        phone=(EditText)findViewById(R.id.etAddPhone);
        instiution=(EditText)findViewById(R.id.etAddInstitution);
        save=(Button)findViewById(R.id.btSave);

    }

    public void clicked(View v)
    {
        String Name=name.getText().toString().trim();
        String Phone=phone.getText().toString().trim();
        String Email=email.getText().toString().trim();
        String Address=address.getText().toString().trim();
        String Institution=instiution.getText().toString().trim();

        StudentModel values= new StudentModel(Name,Email,Phone,Address,Institution);
        long i= db.addStudentDetail(values);
        finish();


        //Intent i = new Intent(getBaseContext(), MainActivity.class);
        //startActivity(i);
        //finish();
    }



   /* @Override
    protected void onPause() {

        super.onDestroy();

    }*/

}
