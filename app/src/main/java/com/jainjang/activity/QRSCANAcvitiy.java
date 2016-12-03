package com.jainjang.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.jainjang.R;
import com.jainjang.fragment.QRAreaFragment;

;

/**
 * Created by Shin on 2016-11-27.
 * qr코드 스캔페이지
 */
public class QRSCANAcvitiy extends Activity {
    Button scanBtn;
    String TAG;
    Fragment qrFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan_activity);
        scanBtn = (Button) findViewById(R.id.scan_btn);

        qrFragment =new QRAreaFragment();

        //스캔 버튼 이벤트
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                fragmentTransaction.replace(R.id.frame, qrFragment);
//                fragmentTransaction.commit();
                IntentIntegrator integrator = new IntentIntegrator(QRSCANAcvitiy.this);
                integrator.setOrientationLocked(false);

                integrator.initiateScan();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(TAG, ">>> requestCode = " + requestCode + ", resultCode = " + resultCode);
        if (requestCode == IntentIntegrator.REQUEST_CODE) {

            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            Log.i(TAG, ">>> result.getContents()   :  " + result.getContents());
            Log.i(TAG, ">>> result.getFormatName()   :  " + result.getFormatName());
        }
    }


}
