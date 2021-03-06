package com.xq.datashow;

import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class ZhuzhuangActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ImageView mBackImageView;
    private WebView mJibentiaoxingWV, mHengxiangtiaoxingWV, mZhengfutiaoxingWV, mDuidiezhuzhuangWV, mJizuobiaoduidieWV, mDuidiehengxiangWV, mJietipubuWV;
    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuzhuang);

        setStatusBar();

        initViews();
    }

    private void initViews() {
        mBackImageView = findViewById(R.id.iv_zhuzhuang_back);
        mBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mJibentiaoxingWV = findViewById(R.id.jibentiaoxing);
        mJibentiaoxingWV.getSettings().setJavaScriptEnabled(true);
        mJibentiaoxingWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mJibentiaoxingWV.getSettings().setAppCacheEnabled(true);
        mJibentiaoxingWV.loadUrl("file:///android_asset/ZZ_jibentiaoxing");

        mHengxiangtiaoxingWV = findViewById(R.id.hengxiangtiaoxing);
        mHengxiangtiaoxingWV.getSettings().setJavaScriptEnabled(true);
        mHengxiangtiaoxingWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mHengxiangtiaoxingWV.getSettings().setAppCacheEnabled(true);
        mHengxiangtiaoxingWV.loadUrl("file:///android_asset/ZZ_hengxiangtiaoxing");

        mDuidiezhuzhuangWV = findViewById(R.id.zhengfutiaoxing);
        mDuidiezhuzhuangWV.getSettings().setJavaScriptEnabled(true);
        mDuidiezhuzhuangWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mDuidiezhuzhuangWV.getSettings().setAppCacheEnabled(true);
        mDuidiezhuzhuangWV.loadUrl("file:///android_asset/ZZ_zhengfutiaoxing");

        mZhengfutiaoxingWV = findViewById(R.id.duidiezhuzhuang);
        mZhengfutiaoxingWV.getSettings().setJavaScriptEnabled(true);
        mZhengfutiaoxingWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mZhengfutiaoxingWV.getSettings().setAppCacheEnabled(true);
        mZhengfutiaoxingWV.loadUrl("file:///android_asset/ZZ_duidiezhuzhuang");

        mJizuobiaoduidieWV = findViewById(R.id.jizuobiaoduidie);
        mJizuobiaoduidieWV.getSettings().setJavaScriptEnabled(true);
        mJizuobiaoduidieWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mJizuobiaoduidieWV.getSettings().setAppCacheEnabled(true);
        mJizuobiaoduidieWV.loadUrl("file:///android_asset/ZZ_jizuobiaoduidie");

        mDuidiehengxiangWV = findViewById(R.id.duidiehengxiang);
        mDuidiehengxiangWV.getSettings().setJavaScriptEnabled(true);
        mDuidiehengxiangWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mDuidiehengxiangWV.getSettings().setAppCacheEnabled(true);
        mDuidiehengxiangWV.loadUrl("file:///android_asset/ZZ_duidiehengxiang");

        mJietipubuWV = findViewById(R.id.jietipubu);
        mJietipubuWV.getSettings().setJavaScriptEnabled(true);
        mJietipubuWV.getSettings().setDefaultTextEncodingName("UTF-8");
        mJietipubuWV.getSettings().setAppCacheEnabled(true);
        mJietipubuWV.loadUrl("file:///android_asset/ZZ_jietipubu");

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_zhuzhuang);
        mRefreshLayout.setOnRefreshListener(this);
        //设置刷新啥时候的小圈圈的颜色，最多设置4种
        mRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mRefreshLayout.setDistanceToTriggerSync(300);
    }

    //设置沉浸式状态栏
    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public void onRefresh() {
        initViews();
        mRefreshLayout.setRefreshing(false);
    }
}
