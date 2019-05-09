package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ordermanagementsystem.Items;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {
    private static final String databaseName = "DictionaryDB";
    private static final int dbVersion = 1;
    private static final String tblItem = "tblItem";
    private static final String tblKot = "tblKot";
    private static final String itemID = "id";
    private static final String item = "itemname";


    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create table tblItem " +
                "(" +
                "id integer primary key autoincrement," +
                " itemname text)";

        String query2 = "Create table tblKot " +
                "(" +
                "id integer primary key autoincrement," +
                " itemname text)";

        db.execSQL(query);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String itemName,SQLiteDatabase db){
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(item,itemName);

        id = db.insert(tblItem,null,contentValues);
        return id;
    }
    public long insertWaiterData(String itemName,SQLiteDatabase db){
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(item,itemName);

        id = db.insert(tblKot,null,contentValues);
        return id;
    }

//    public List<model.Word> GetAllWords(SQLiteDatabase db){
//        List<Word> dictionaryList = new ArrayList<>();
//        Cursor cursor = db.rawQuery("select * from tblWord",null);
//        if (cursor.getCount()>0){
//            while(cursor.moveToNext()){
//                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
//            }
//        }
//        return dictionaryList;
//    }

    public List<Items> GetAllItems(SQLiteDatabase db) {
        List<Items> itemsList = new ArrayList<>();
        String[] columns = {itemID,item};
        Cursor cursor = db.query(tblItem, columns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                itemsList.add(new Items(cursor.getInt(0), cursor.getString(1)));
            }
        }
        return itemsList;
    }
    public List<Items> GetAllWaiterItems(SQLiteDatabase db) {
        List<Items> itemsList = new ArrayList<>();
        String[] columns = {itemID,item};
        Cursor cursor = db.query(tblKot, columns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                itemsList.add(new Items(cursor.getInt(0), cursor.getString(1)));
            }
        }
        return itemsList;
    }

//    public List<Word> GetWordByName(String word,SQLiteDatabase db){
//        List<Word> dictionaryList = new ArrayList<>();
//        Cursor cursor = db.rawQuery("select * from tblWord where Word =?",new String[]{word});
//        if (cursor.getCount()>0){
//            while (cursor.moveToNext()){
//                dictionaryList.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
//            }
//        }
//        return dictionaryList;
//
//    }
}
