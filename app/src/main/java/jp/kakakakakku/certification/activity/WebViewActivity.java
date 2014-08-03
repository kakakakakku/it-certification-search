package jp.kakakakakku.certification.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import jp.kakakakakku.certification.R;

public class WebViewActivity extends Activity {

    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getStringExtra("url");

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.art_web_info);
        mWebView = (WebView) findViewById(R.id.info_web);
        mWebView.setVerticalScrollbarOverlay(true);

        // WebViewClientを組み込む
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                setProgressBarIndeterminateVisibility(true);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setProgressBarIndeterminateVisibility(false);
            }
        });

        // ズーム機能を有効にする
//        mWebView.getSettings().setBuiltInZoomControls(true);
        // JavaScriptを有効にする
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 右10pxの余白を消す
        mWebView.setVerticalScrollbarOverlay(true);

        mWebView.loadUrl(url);

    }

    // バックキー押下時の動作
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack() == true) {
            mWebView.goBack();
            mWebView.getUrl();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
