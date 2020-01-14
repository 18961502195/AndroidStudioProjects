package com.example.company1;


import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.Gravity;

import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindview();
        rb_channel.setChecked(true);
    }
    //解决drawlayout与发fragment


    private void bindview() {

        //底部导航栏id
        rb_channel = findViewById(R.id.rb_channel);
        rb_message = findViewById(R.id.rb_message);
        rb_better = findViewById(R.id.rb_better);
        rb_setting = findViewById(R.id.rb_setting);
        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setFocusable(true);

        vpager = findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
                if (state == 2) {
                    switch (vpager.getCurrentItem()) {
                        case PAGE_ONE:
                            rb_channel.setChecked(true);
                            break;
                        case PAGE_TWO:
                            rb_message.setChecked(true);
                            break;
                        case PAGE_THREE:
                            rb_better.setChecked(true);
                            break;
                        case PAGE_FOUR:
                            rb_setting.setChecked(true);
                            break;
                    }
                }
            }
        });

        rg_tab_bar.setOnCheckedChangeListener(((group, checkedId) -> {
            System.out.println("点击了底层拦");
            switch (checkedId) {
                case R.id.rb_channel:
                    vpager.setCurrentItem(PAGE_ONE);
                    break;
                case R.id.rb_message:
                    vpager.setCurrentItem(PAGE_TWO);
                    break;
                case R.id.rb_better:
                    vpager.setCurrentItem(PAGE_THREE);
                    break;
                case R.id.rb_setting:
                    vpager.setCurrentItem(PAGE_FOUR);
                    break;
            }
        }));
    }
}
