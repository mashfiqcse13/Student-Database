package com.example.home.labproject1;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    ArrayList<StudentModel> studentModelArrayList;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context,  ArrayList<StudentModel> studentModelArrayList, Integer[] imgid) {
        super(context, R.layout.mylist, studentModelArrayList);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.studentModelArrayList=studentModelArrayList;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.ditailsSubtitle);
        StudentModel student;
        student=studentModelArrayList.get(position);

        txtTitle.setText(student.name);
        imageView.setImageResource(imgid[0]);
        extratxt.setText(student.institution);
        return rowView;

    };
}