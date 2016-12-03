package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-24.
 * 메인탭의 돋보기 아이콘 클릭시 오는 액티비티 검색창 안에는 (1차)해시태그나
 * (2차)친구코드검색 , 검색팝업유형선택 등이있다.
 * 현재 검색결과에대한 액티비티가 따로 없어서 구현제한됨
 */

public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);



    }
}

