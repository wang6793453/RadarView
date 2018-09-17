package com.bugu.myapplication01;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private RadarView mRadarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mRadarView = (RadarView) findViewById(R.id.radar_view);
        mRadarView.setSearching(true);
        mRadarView.addPoint();
        mRadarView.addPoint();
        timer.start();
    }


    /**
     * 延时处理
     * 参数:总体延时时间/间隔操作时间
     */
    private CountDownTimer timer = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //每一次刷新操作
            mRadarView.addPoint();
        }

        @Override
        public void onFinish() {

            timer.cancel();//关闭计时器
            mRadarView.setSearching(false);
        }
    };

}