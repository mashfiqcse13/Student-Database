package com.example.home.labproject1;

/**
 * Created by home on 6/6/2015.
 */
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Details extends ActionBarActivity {

    TextView name,address,addressDes,phone,phoneNum,email,emailAddress,institution;
    ImageView Email,Phone,Address;



    Integer[] imgid={
            R.drawable.male,
            R.drawable.female,

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Address=(ImageView)findViewById(R.id.imageView3);
        Phone=(ImageView)findViewById(R.id.imageView4);
        Email=(ImageView)findViewById(R.id.imageView5);

        name=(TextView)findViewById(R.id.textView2);
        institution=(TextView)findViewById(R.id.textView3);

        address=(TextView)findViewById(R.id.tvAddressTitle);
        addressDes=(TextView)findViewById(R.id.tvAddressDesc);
        email=(TextView)findViewById(R.id.tvEmailTitle);
        emailAddress=(TextView)findViewById(R.id.tvEmailAddress);
        phone=(TextView)findViewById(R.id.tvPhoneTitle);
        phoneNum=(TextView)findViewById(R.id.tvPhoneNumber);







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_ditails) {
            Intent i = new Intent(getBaseContext(), Add.class);
            startActivity(i);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}

