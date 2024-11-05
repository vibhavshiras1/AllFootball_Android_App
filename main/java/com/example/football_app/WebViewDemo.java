package com.example.football_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemo extends AppCompatActivity {
    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);

        String url1 = getIntent().getStringExtra("url");
        webView1 = (WebView) findViewById(R.id.webview3);
        webView1.setWebViewClient(new WebViewClient());
        webView1.loadUrl(url1);
    }

    @Override
    public void onBackPressed() {
        if(webView1.canGoBack()){
            webView1.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}