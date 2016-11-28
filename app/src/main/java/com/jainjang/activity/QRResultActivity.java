package com.jainjang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jainjang.R;

/**
 * Created by Shin on 2016-11-27.
 * 큐알코드 결과 액티비티
 */
public class QRResultActivity extends Activity {
    private static final String URL_TO_LOAD = "http://google.com";
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan_result);

        ImageView qnaImage = (ImageView) findViewById(R.id.qna_btn);
        ImageView reviewImage = (ImageView) findViewById(R.id.review_btn);   //리뷰,qna 이벤트용

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


        //웹뷰 부분 html 커스텀 필요

        mWebView = (WebView)findViewById(R.id.result_web);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://google.com");
        mWebView.setWebViewClient(new WebViewClientClass());
    }

    //shoudOverideUrlLoding 이외의 다른것 찾아봐야됨
    class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



}

