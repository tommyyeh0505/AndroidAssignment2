package com.example.tommy.assignment2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
public class SQLHelper2 extends SQLiteOpenHelper {
    private static final String DB_NAME = "KidList.db";
    private static final int DB_VERSION = 2;
    private Context context;
    public SQLHelper2(Context context) {
        // The 3'rd parameter (null) is an advanced feature relating to cursors
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        SQLiteDatabase db = this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

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
                        Integer.parseInt(cursor.getString(9)),
                        Integer.parseInt(cursor.getString(10)),
                        Boolean.parseBoolean(cursor.getString(11)),
                        cursor.getString(12)));
            } while (cursor.moveToNext());
        }
        return children;
    }

    public void deleteChild(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("DELETING:", "id=" + i);
        db.delete("KIDLIST", "_id" + "=" + i, null);
    }
}
