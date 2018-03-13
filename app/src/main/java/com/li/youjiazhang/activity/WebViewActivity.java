package com.li.youjiazhang.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.li.youjiazhang.BaseActivity;
import com.li.youjiazhang.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initWeb();
        getSearchView().setVisibility(View.GONE);
        getToolbarTitle().setText("详情");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    private void initWeb(){
        webview.loadUrl("https://www.baidu.com/");
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }
}
