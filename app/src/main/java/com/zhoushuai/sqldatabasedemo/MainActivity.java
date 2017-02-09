package com.zhoushuai.sqldatabasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       SQLiteDatabase db = openOrCreateDatabase("userzhou.db",
                MODE_PRIVATE, null);
        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
//        db.execSQL("insert into usertb(name,age,sex) values('张三',20,'男')");
//        db.execSQL("insert into usertb(name,age,sex) values('李四',22,'男')");
//        db.execSQL("insert into usertb(name,age,sex) values('王五',18,'女')");
//        db.execSQL("insert into usertb(name,age,sex) values('赵六',19,'男')");
    /*    ContentValues cv=new ContentValues();
        cv.put("name","钱七");
        cv.put("age",18);
        cv.put("sex","女");
        db.insert("usertb",null,cv);
        cv.clear();
        cv.put("name","周八");
        cv.put("age",22);
        cv.put("sex","男");
        db.insert("usertb",null,cv);
        cv.clear();
        cv.put("name","王明");
        cv.put("age",19);
        cv.put("sex","男");
        db.insert("usertb",null,cv);
        cv.clear();
        cv.put("sex","女");
        db.update("usertb",cv,"name like?",new String[]{"王明"});
*/

//       db.execSQL("delete from usertb");
        Log.i("TABLE", "123********************************");
       //Cursor c = db.query("usertb",null,"_id>?",new String[]{"0"},null,null,"name");
                  Cursor c= db.rawQuery("select * from usertb",null);
        if(c!=null){
            String[] names=c.getColumnNames();
            while(c.moveToNext()){
                for(String getname:names) {

                    Log.i("TABLE", "name:" + c.getString(c.getColumnIndex(getname)));
                    Log.i("TABLE", "////////////////////////////");

                }
            }
            c.close();
        }
                 db.close();

    }
}