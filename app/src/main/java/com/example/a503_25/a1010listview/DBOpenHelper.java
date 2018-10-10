package com.example.a503_25.a1010listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    // 첫번째는 Context 두번쨰는 파일명 // 세번째는 Cursor 네번째는 버전
    public DBOpenHelper(Context context){// 2번쨰가 파일 이름 세번쨰가 커서문제?
        super(context, "data.db", null,1);
    }

    //데이터베이스를 처음 사용할 때 호출되는 메소드
    //테이블을 생성하고 샘플 데이터를 추가
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_data(_id integer primary key autoincrement, name text, position text);");
        db.execSQL("insert into tb_data(name,position) values('james','pf')");
        db.execSQL("insert into tb_data(name,position) values('cobe','sg')");

    }

    //버전이 변경되었을 때 호출되는 메소드
    //테이블을 삭제하고 다시 생성
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tb_data;");
        onCreate(db);
    }
}
