package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-25.
 * 메인탭에서 사람아이콘클릭시 넘어오는 마이페이지
 * 프로필 변경 앱설정 스탬프 마일리지 쿠폰등을 확인할수있다.
 */
public class MypageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_activity);
    }
}
