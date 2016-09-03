package com.example.priyanka.connect;

import android.app.ActionBar;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fragmentTitle)
    TextView mActivityTitle;
    @Bind(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewPagerAndTabs();
    }

    private void initViewPagerAndTabs() {
        mAppBarLayout.setExpanded(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        FirstTab fragment = new FirstTab();
        //   fragment.setActivityCallback(this);
        pagerAdapter.addFragment(fragment);
        pagerAdapter.addFragment(new SecondTab());

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabListener(viewPager));
        tabLayout.getTabAt(0).setIcon(R.drawable.ques);
        tabLayout.getTabAt(1).setIcon(R.drawable.answer_question);
        tabLayout.getTabAt(0).select();
        mActivityTitle.setText(getResources().getString(R.string.my_questions));
        //      fragment.setTab(tabLayout.getTabAt(mSelectedTabIndex));
    }


    public class TabListener extends TabLayout.ViewPagerOnTabSelectedListener {
        public TabListener(ViewPager viewPager) {
            super(viewPager);
        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            super.onTabSelected(tab);

            mAppBarLayout.setExpanded(true);
            int position = tab.getPosition();
            int iconId = R.drawable.piggy_bank;
            switch (position) {

                case 0:
                    iconId = R.drawable.piggy_bank;
                    setFragmentTitle(position);
                    break;
                case 1:
                    iconId = R.drawable.piggy_bank;
                    setFragmentTitle(position);
                    break;

            }
            //      tab.setIcon(iconId);
        }


        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            super.onTabUnselected(tab);

            int position = tab.getPosition();
       /* int iconId = R.drawable.ic_nav_more_unselected;
        switch (position) {

            case 0:
                RelativeLayout relativeLayout = (RelativeLayout) tab.getCustomView();
                if (null != relativeLayout) {
                    ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
                    imageView.setImageResource(R.drawable.ic_nav_leads_unselected);
                }
                //iconId = R.drawable.ic_nav_leads_unselected;
                break;
            case 1:
                iconId = R.drawable.ic_nav_my_listing_unselected;
                break;
        }
        if (position != 0) {
            tab.setIcon(iconId);
        }*/
        }


        private void setFragmentTitle(int position) {
            if (null == mActivityTitle) {
                return;
            }
            switch (position) {
                case 0:
                    mActivityTitle.setText(getResources().getString(R.string.my_questions));
                    break;
                case 1:
                    mActivityTitle.setText(getResources().getString(R.string.answer_questions));
                    break;
            }
        }

    }
}
