package com.example.japan.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.japan.Vocabulary;
import com.example.japan.model.HandBook;
import com.example.japan.model.VocabularyHandBook;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private Context context;
    private String DBName ="handbook";

    public DatabaseManager(Context context) {
        super(context,"handbook",null,1);
        this.context = context;
        doCreateHandbookTable();
        doCreateContentHandbookTable();
    }

    public DatabaseManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    public void doCreateHandbookTable(){
        String sql = "CREATE TABLE IF NOT EXISTS tblhandbook(";
        sql += " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,";
        sql += " name TEXT,";
        sql += " datecreate TEXT)";
        QueryData(sql);
    }

    public void doCreateContentHandbookTable(){
        String sql = "CREATE TABLE IF NOT EXISTS tblcontenthandbook(";
        sql += " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,";
        sql += " jword TEXT,";
        sql += " vnword TEXT,";
        sql += " type TEXT,";
        sql += " datecreate TEXT,";
        sql += " idhandbook INT NOT NULL CONSTRAINT id REFERENCES tblhandbook(id) ON DELETE CASCADE)";
        QueryData(sql);
    }

    public ArrayList<HandBook> getDataHandBook(){
        Cursor data = GetData("SELECT * FROM tblhandbook");
        ArrayList<HandBook> list  = new ArrayList<HandBook>();
        while (data.moveToNext()){
            int id = data.getInt(0);
            String name = data.getString(1);
            String dateCreate = data.getString(2);
            list.add(new HandBook(id,name,dateCreate));
        }
        return list;
    }

    public HandBook getDataHanBookById(int id){
        HandBook handBook = new HandBook();
        Cursor data = GetData("SELECT * FROM tblhandbook WHERE id =" + id);
        data.moveToNext();
        handBook.setId(data.getInt(0));
        handBook.setName(data.getString(1));
        handBook.setDataCreate(data.getString(2));
        return handBook;
    }


    public void insertRowHandBook(String name, String dateCreate){
        String sql = "INSERT INTO tblhandbook (name,datecreate) VALUES ('" + name + "','" + dateCreate +"')";
        QueryData(sql);
    }

    public void updateRowHandBook(int id,String name){
        String sql = "UPDATE tblhandbook SET name = '"+name+"' WHERE id ="+id;
        QueryData(sql);
    }

    public void deleteRowHandBook(int id){
        String sql = "DELETE FROM tblhandbook WHERE id = " + id;
        QueryData(sql);
    }

    public ArrayList<VocabularyHandBook> getDataContentHandBook(){
        Cursor data = GetData("SELECT * FROM tblcontenthandbook");
        ArrayList<VocabularyHandBook> listContent  = new ArrayList<VocabularyHandBook>();
        while (data.moveToNext()){
            int id = data.getInt(0);
            String jWord = data.getString(1);
            String vnWord = data.getString(2);
            String type = data.getString(3);
            String dateCreate = data.getString(4);
            int idHandBook = data.getInt(5);
            listContent.add(new VocabularyHandBook(id,jWord,vnWord,type,dateCreate,idHandBook));
        }
        return listContent;
    }

    public VocabularyHandBook getDataContentHanBookById(int id){
        VocabularyHandBook vocabularyHandBook = new VocabularyHandBook();
        Cursor data = GetData("SELECT * FROM tblcontenthandbook WHERE id =" + id);
        data.moveToNext();
        vocabularyHandBook.setId(data.getInt(0));
        vocabularyHandBook.setjWord(data.getString(1));
        vocabularyHandBook.setVnWord(data.getString(2));
        vocabularyHandBook.setType(data.getString(3));
        vocabularyHandBook.setDateCreate(data.getString(4));
        vocabularyHandBook.setIdHandBook(data.getInt(5));
        return vocabularyHandBook;
    }

    public ArrayList<VocabularyHandBook> getListDataVocabularyByIdHandBook(int idHandBook){
        ArrayList<VocabularyHandBook> list = new ArrayList<VocabularyHandBook>();
        Cursor data = GetData("SELECT * FROM tblcontenthandbook WHERE idhandbook = " + idHandBook);
        while (data.moveToNext()){
            int id = data.getInt(0);
            String jWord = data.getString(1);
            String vnWord = data.getString(2);
            String type = data.getString(3);
            String dateCreate = data.getString(4);
            list.add(new VocabularyHandBook(id,jWord,vnWord,type,dateCreate,idHandBook));
        }
        return list;
    }

    public void insertRowContentHandBook(String jWord,String vnWord, String type, String dateCreate, int idHandBook){
        String sql = "INSERT INTO tblcontenthandbook (jword,vnword,type,datecreate,idhandbook) VALUES" +
                " ('" + jWord + "','" + vnWord +"','"+ type+"','"+dateCreate +"',"+idHandBook +")";
        QueryData(sql);
    }

    public void updateRowContentHandBook(int id,String jWord,String vnWord, String type, String dateCreate, int idHandBook){
        String sql = "UPDATE tblcontenthandbook SET " +
                "jword = '"+jWord+"', vnword = '"+ vnWord+"', type = '"+type+"', datecreate = '"
                + dateCreate +"', idhandbook = " + idHandBook  +" WHERE id ="+id;
        QueryData(sql);
    }

    public void deleteRowContentHandBook(int id){
        String sql = "DELETE FROM tblcontenthandbook WHERE id = " + id;
        QueryData(sql);
    }
}
