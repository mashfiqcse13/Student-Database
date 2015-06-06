package com.example.home.labproject1;

/**
 * Created by home on 6/6/2015.
 */

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME="students_database";

    private static final  int DATABASE_VERSION=1;

    private  static final  String TABLE_STUDENTS="students";

    private static final  String KEY_ID="id";
    private static final  String KEY_NAME="name";
    private static final  String KEY_PHONE="phone";
    private static final  String KEY_EMAIL="email";
    private static final  String KEY_ADDRESS="address";
    private static final  String KEY_INSTITUTION="institution";


    private static final  String CREATE_TABLE_STUDENTS="CREATE TABLE "+TABLE_STUDENTS+"("+KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+" TEXT,"+KEY_PHONE+"TEXT,"+KEY_EMAIL+" TEXT,"+KEY_ADDRESS+" TEXT,"+KEY_INSTITUTION+" TEXT);";


    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_STUDENTS);
        onCreate(db);

    }

    public long addStudentDetail(StudentModel student)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_NAME,student.name);
        values.put(KEY_PHONE,student.phone);
        values.put(KEY_EMAIL,student.email);
        values.put(KEY_ADDRESS,student.address);
        values.put(KEY_INSTITUTION, student.institution);



        long insert= db.insert(TABLE_STUDENTS,null,values);

        return  insert;

    }

    public  void deletEntry(long id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_STUDENTS,KEY_ID+" = ?",new String[]{String.valueOf(id)});
    }

    public int update(StudentModel student) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,student.name);
        values.put(KEY_PHONE,student.phone);
        values.put(KEY_EMAIL,student.email);
        values.put(KEY_ADDRESS,student.address);
        values.put(KEY_INSTITUTION, student.institution);
        int i = db.update(TABLE_STUDENTS, values, KEY_ID + " = " + student.id, null);
        return i;
    }


    public ArrayList<StudentModel>getALLstudentsList(){
        ArrayList<StudentModel>studentArrayList= new ArrayList<StudentModel>();
        String selectQuery="SELECT * FROM"+TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if(c.moveToFirst())
        {
            do{
                StudentModel students = new StudentModel();
                students.id=c.getInt(c.getColumnIndex(KEY_ID));
                students.name=c.getString(c.getColumnIndex(KEY_NAME));
                students.phone=c.getString(c.getColumnIndex(KEY_PHONE));
                students.email=c.getString(c.getColumnIndex(KEY_EMAIL));
                students.address=c.getString(c.getColumnIndex(KEY_ADDRESS));
                students.institution=c.getString(c.getColumnIndex(KEY_INSTITUTION));

                studentArrayList.add(students);
            }while (c.moveToNext());
        } return  studentArrayList;
    }


}
