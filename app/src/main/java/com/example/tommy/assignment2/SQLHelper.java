package com.example.tommy.assignment2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
public class SQLHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "KidList.db";
    private static final int DB_VERSION = 2;
    private Context context;
    public SQLHelper(Context context) {
        // The 3'rd parameter (null) is an advanced feature relating to cursors
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("NUMBER OF CHILDREN IN CHILD CLASS ARRAY: ", "" + Child.CHILDREN.length);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS KIDLIST");
            db.execSQL(getCreateKidListTableSql());
        }
    }
    private String getCreateKidListTableSql() {
        String sql = "";
        sql += "CREATE TABLE KidList (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "firstName TEXT, ";
        sql += "lastName TEXT,";
        sql += "birthDate TEXT,";
        sql += "street TEXT,";
        sql += "City TEXT,";
        sql += "Province TEXT,";
        sql += "PostalCode TEXT,";
        sql += "Country TEXT,";
        sql += "Latitude DECIMAL(4,2),";
        sql += "Longitude DECIMAL(4,2),";
        sql += "IsNaughty BOOLEAN,";
        sql += "DateCreated TEXT);";
        return sql;
    }
    public void insertChild(Child kid) {
        ContentValues values = new ContentValues();
        values.put("firstName", kid.getFirstName());
        values.put("lastName", kid.getLastName());
        values.put("birthDate", kid.getBirthDate());
        values.put("street", kid.getStreet());
        values.put("City", kid.getCity());
        values.put("Province", kid.getProvince());
        values.put("PostalCode", kid.getPostalCode());
        values.put("Country", kid.getCountry());
        values.put("Latitude", kid.getLatitude());
        values.put("Longitude", kid.getLongitude());
        values.put("IsNaughty", kid.getIsNaughty());
        values.put("DateCreated", kid.getDateCreated());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("KidList", null, values);
        Log.e("ADD", "CHILD ADDED");
    }

    public ArrayList<Child> getChildren() {
        ArrayList<Child> children = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * FROM KidList", null);
        int count = cursor.getCount();
        Log.e("COUNT", "NUMBER OF KIDS " + count);
        children = new ArrayList<Child>();
        if (cursor.moveToFirst()) {
            int ndx=0;
            do {
                Log.e("ID from DATABASE", cursor.getString(0));

                children.add(new Child(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        Double.parseDouble(cursor.getString(9)),
                        Double.parseDouble(cursor.getString(10)),
                        Boolean.parseBoolean(cursor.getString(11)),
                        cursor.getString(12)));
            } while (cursor.moveToNext());
        }
        return children;
    }

    public ArrayList<Child> getChildren(String s) {
        ArrayList<Child> children = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * FROM KidList WHERE (firstName LIKE \'%" + s + "%\' OR lastName LIKE \'%" + s + "%\')", null);
        int count = cursor.getCount();
        Log.e("COUNT", "NUMBER OF KIDS " + count);
        children = new ArrayList<Child>();
        if (cursor.moveToFirst()) {
            int ndx=0;
            do {
                Log.e("ID from DATABASE", cursor.getString(0));

                children.add(new Child(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        Double.parseDouble(cursor.getString(9)),
                        Double.parseDouble(cursor.getString(10)),
                        Boolean.parseBoolean(cursor.getString(11)),
                        cursor.getString(12)));
            } while (cursor.moveToNext());
        }
        return children;
    }

    public Child getChild(int i) {
        for(Child c : getChildren()){
            if(c.getId() == i){
                return c;
            }
        }
        return null;

    }



    public void deleteChild(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("Deleting id=", ""+i);
        db.delete("KIDLIST", "_id" + "=" + i, null);
    }




}
