package com.example.home.labproject1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {



    ArrayList<Integer>listId=new ArrayList<>();
    ListView list;
    ArrayList<StudentModel> studentModelArrayList;
    DataBaseHelper db;

    Integer[] imgid={
            R.drawable.male,
            R.drawable.female,

    };



    CustomListAdapter adapter=new CustomListAdapter(this, studentModelArrayList, imgid);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);

        db= new DataBaseHelper(getApplicationContext());

       genarateList();


    }
    public  void genarateList()
    {
        studentModelArrayList = db.getALLstudentsList();
        list.setAdapter(adapter);
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
