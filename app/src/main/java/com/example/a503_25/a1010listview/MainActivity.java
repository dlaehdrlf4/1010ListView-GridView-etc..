package com.example.a503_25.a1010listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SimpleAdapter를 이용해서 출력할 데이터 생성
        //List<Map<String, Object>> 구조

        List<Map<String,String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("name","르브론");
        map.put("position","powerfoward");
        list.add(map);

        map = new HashMap<>();
        map.put("name","코비");
        map.put("position", "smallgard");
        list.add(map);

        //데이터 출력을 위한 Adapter 생성
        //첫번째는 Context
        //두번째는 데이터 세번쨰는 셀의 출력모양
        //네번쨰는 출력할 데이터의 키 배열
        //다섯번째는 출력할 셀 안의 id

        //데이터 출력을 위한 Adapter 생성
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,new String[]{"name", "postion"}, new int []{android.R.id.text1,android.R.id.text2});

        //ListView 에 adapter를 연결해서 출력
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
