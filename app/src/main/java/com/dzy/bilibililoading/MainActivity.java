package com.dzy.bilibililoading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dzy.bilibililoading.ptr.PullToRefreshLayout;
import com.dzy.bilibililoading.ptr.RefreshLinstener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PullToRefreshLayout ptr = (PullToRefreshLayout) findViewById(R.id.ptrlayout);
        BilibiliHeader header = new BilibiliHeader(this);
        ptr.setHeader(header);

        ptr.setRefreshLinstener(new RefreshLinstener() {
            @Override
            public void onRefreshStart() {
                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptr.succeedRefresh();
                    }
                },2000);
            }
        });
    }
}
