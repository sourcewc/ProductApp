package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-28.
 * qr코드 스캔후 리뷰버튼클릭시 이쪽으로
 */

public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_review);
    }
}
