package com.example.a503_25.a1010listview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursorList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_list);

        ListView listView = (ListView)findViewById(R.id.simplelist);
        ListView cursorlist = (ListView)findViewById(R.id.cursorlist);

        //데이터베이스 사용 클래스의 객체 생성 - 이러면 onCreate가 한번 호출
        SQLiteOpenHelper helper = new DBOpenHelper(this);
        //데이터베이스에서 읽기 작업
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tb_data;",null);
        //읽어온 데이터를 List<Map>에 저장하기
        List<Map<String, Object>> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", cursor.getString(1));
            map.put("position", cursor.getString(2));
            list.add(map);
        }
        db.close();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,new String[]{"name","position"},new int[]{android.R.id.text1,android.R.id.text2});
        listView.setAdapter(simpleAdapter);

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,new String[]{"name","position"},new int[]{android.R.id.text1, android.R.id.text2},CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        cursorlist.setAdapter(cursorAdapter);


    }
}


