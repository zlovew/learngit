package qainfeng.myshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import qainfeng.myshop.R;

public class WebViewActivity extends AppCompatActivity {

    private ImageView mImageView;
    private WebView mWebView;
    private String mUrl;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
        aboutWebView();

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void aboutWebView() {
        mWebView.loadUrl(mUrl);

        WebSettings settings = mWebView.getSettings();
        settings.setBuiltInZoomControls(true);// 显示缩放按钮(wap网页不支持)
        settings.setUseWideViewPort(true);// 支持双击缩放(wap网页不支持)
        settings.setJavaScriptEnabled(true);// 支持js功能//这个一般都要写
        mWebView.setWebViewClient(new WebViewClient(){//这要new出来 就会在本webview中打开

            //以下都是自己重写的
            @Override//这个  不用重写 也会在第本webView中打开
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //开启页面的时候  比如显示进度条
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);//显示进度条
            }

            //加载页面 完成的时候  比如关闭进度条
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);//关闭进度条
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient(){
            //	进度条改变的时候//加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //get the newProgress and refresh progress bar
                progressBar.setProgress(newProgress);//设置progressBar的加载进度
            }
            //设置标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
            }

        });
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.iv_webview);
        mWebView = (WebView) findViewById(R.id.wv_web);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        progressBar = (ProgressBar) findViewById(R.id.pb_webview);
    }
}
