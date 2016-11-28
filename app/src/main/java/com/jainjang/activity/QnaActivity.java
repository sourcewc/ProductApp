package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-28.
 * qr코드 스캔후 qna 버튼 클릭시 이쪽으로
 */

public class QnaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_qna);
    }
}
