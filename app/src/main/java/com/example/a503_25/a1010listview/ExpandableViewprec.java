package com.example.a503_25.a1010listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableViewprec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_viewprec);

        //제목으로 사용할 문자열 배열 생성
        String [] main = {
                "르브론","코비브라이언트","마이클조던"
        };

        //제목을 누르면 보여질 문자열 배열 생성
        String [][] sub = {
                {"파워포워드","스몰포워드","리딩포워드"},{"슈팅가드","리딩가드","코비신발"},{"황제","덩크","슈팅가드","조던신발"}
        };

        //위의 데이터를 가지고 출력할 수 있는 데이터 생성
        List<Map<String, String>> mainData = new ArrayList<>();
        List<List<Map<String,String>>>subData = new ArrayList<>();
        for(int i=0; i<main.length; i=i+1){
            Map<String, String>mainMap = new HashMap<>();
            mainMap.put("main",main[i]);
            mainData.add(mainMap);

            List<Map<String, String>> subList = new ArrayList<>();
            for(int j=0; j <sub[i].length;j=j+1){
                Map<String, String> subMap = new HashMap<>();
                subMap.put("sub",sub[i][j]);
                subList.add(subMap);
            }
            subData.add(subList);
        }
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.listView);
        ExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,mainData,android.R.layout.simple_list_item_1,
                new String[]{"main"},new int[]{android.R.id.text1},subData,android.R.layout.simple_list_item_1,new String[]{"sub"},new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
    }
}
