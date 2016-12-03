package com.jainjang.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jainjang.R;

;

/**
 * Created by Shin on 2016-12-02.
 * qr코드 스캔버튼클릭시 활성화되는 프레그먼트 영역
 */

public class QRAreaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.area_layout,container,false);
//        IntentIntegrator integrator = new IntentIntegrator(QRAreaFragment.this);
//        integrator.setOrientationLocked(false);
//        integrator.initiateScan();
        return view;
    }
}
