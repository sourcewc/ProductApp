package com.jainjang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-27.
 * 큐알코드 결과 액티비티
 */
public class QRResultActivity extends Activity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan_result);

        ImageView qnaImage = (ImageView) findViewById(R.id.qna_btn);
        ImageView reviewImage = (ImageView) findViewById(R.id.review_btn);   //리뷰,qna 이벤트용
        ImageView qrMore=(ImageView)findViewById(R.id.qr_more); //더보기 버튼


        qnaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRResultActivity.this, QnaActivity.class);
                startActivity(intent);
            }
        });

        reviewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRResultActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });
        qrMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClick(view);
            }
        });



        //웹뷰 부분 html 파일필요 html소스는 main/assets 안에

        mWebView = (WebView)findViewById(R.id.result_web);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);

        mWebView.loadUrl("file:///android_asset/HelloWorld.html");


    }

    //옵션 생성, 셀렉트
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.qr_result_menu, menu);
        return true;

    }
    public void mOnClick(View v) {
        PopupMenu popup = new PopupMenu(this,v);
        MenuInflater inflater =popup.getMenuInflater();
        Menu menu= popup.getMenu();
        inflater.inflate(R.menu.qr_result_menu,menu);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_itemqna:
                        return true;
                    case R.id.menu_request_stamp:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    /////////////////
}

