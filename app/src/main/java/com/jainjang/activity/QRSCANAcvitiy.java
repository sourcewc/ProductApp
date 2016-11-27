package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-27.
 * qr코드 스캔페이지
 */
public class QRSCANAcvitiy extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan_activity);
    }
}
