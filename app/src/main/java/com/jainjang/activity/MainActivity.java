package com.jainjang.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.jainjang.R;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab);

        Resources res = getResources(); //리소스 객체 생성
        TabHost tabHost = getTabHost(); //탭을 붙이기위한 탭호스객체선언
        TabHost.TabSpec spec; //탭호스트에 붙일 각각의 탭스펙을 선언 ; 각 탭의 메뉴와 컨텐츠를 위한 객체
        Intent intent; //각탭에서 사용할 인텐트 선언

        //인텐트 생성
        intent = new Intent().setClass(this, QRSCANAcvitiy.class);
        //각 탭의 메뉴와 컨텐츠를 위한 객체 생성
        spec = tabHost.newTabSpec("textList").setIndicator("",res.getDrawable(R.drawable.friendsrequest)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, HistoryActivity.class);
        //각 탭의 메뉴와 컨텐츠를 위한 객체 생성
        spec = tabHost.newTabSpec("textList").setIndicator("",res.getDrawable(R.drawable.friendsrequest)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, SearchActivity.class);
        //각 탭의 메뉴와 컨텐츠를 위한 객체 생성
        spec = tabHost.newTabSpec("textList").setIndicator("",res.getDrawable(R.drawable.friendsrequest)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, MypageActivity.class);
        //각 탭의 메뉴와 컨텐츠를 위한 객체 생성
        spec = tabHost.newTabSpec("textList").setIndicator("",res.getDrawable(R.drawable.friendsrequest)).setContent(intent);
        tabHost.addTab(spec);


        tabHost.setCurrentTab(1); //현재화면에 보여질 탭의 위치를 결정

    }
}
