package com.example.kaitlynchandler.assignment4part2;
/**
 * Created by kaitlynchandler on 3/26/18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kaitlynchandler on 3/26/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "synonyms.db";
    private static final String TABLE_NAME = "synonyms_data";
    private static final String COL_1 = "SYNONYM1";
    private static final String COL_2 = "SYNONYM2";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);

    }


    public boolean insertSyn(Synonyms s) {
        String syn1 = s.getSynonym1();
        String syn2 = s.getSynonym2();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1, syn1);
        values.put(COL_2, syn2);
        Log.d(DATABASE_NAME, "addData: Adding " + syn1 + " " + syn2 +
                " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1 ";
        Cursor res = db.rawQuery(query, null);
        return res;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                " SYNONYM1 TEXT, " +
                " SYNONYM2 TEXT, " +
                ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}