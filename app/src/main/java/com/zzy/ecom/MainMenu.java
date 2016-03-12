package com.zzy.ecom;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import java.util.ArrayList;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.*;


public class MainMenu extends SlidingFragmentActivity {

    private ViewPager myViewPager;
    private ActionBar myActionBar;

    final int titleNumber = 3;

    private PlazaFragment plazaFragment;
    private ActivityFragment activityFragment;
    private RecommendFragment recommendFragment;
    private BehindMenuFragment behindFragment;
    private String[] titleTexts;
    private ArrayList<Fragment> fragmentArrayList;
    private ActionBar.Tab[] myTabs = new ActionBar.Tab[titleNumber];

    private SlidingMenu mSlidingMenu;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // behind menu
        this.initBehindMenu();

        // viewpager
        this.initViewPager();

        // actionbar
        setActionBar();
    }

    private void
    initBehindMenu()
    {
        setBehindContentView(R.layout.behind_menu);
        behindFragment = new BehindMenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.behind_menu_framelayout, behindFragment).commit();

        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.RIGHT);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        mSlidingMenu.setFadeDegree(0.35f);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
    }

    private void
    initViewPager()
    {
        myViewPager = (ViewPager) findViewById(R.id.view_pager);

        //fragment initialize
        plazaFragment = new PlazaFragment();
        activityFragment = new ActivityFragment();
        recommendFragment = new RecommendFragment();

        //add fragments to arraylist
        fragmentArrayList = new ArrayList<Fragment>();
        fragmentArrayList.add(plazaFragment);
        fragmentArrayList.add(activityFragment);
        fragmentArrayList.add(recommendFragment);

        //addresses initialize
        titleTexts = new String[titleNumber];
        titleTexts[0] = getString(R.string.title01);
        titleTexts[1] = getString(R.string.title02);
        titleTexts[2] = getString(R.string.title03);

        //view pager adapter initialize
        FragmentPagerAdapter myPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentArrayList.get(position);
            }

            @Override
            public int getCount() {
                return titleNumber;
            }
        };
        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setOnPageChangeListener(myPageChangeListener);
    }

    private void
    setActionBar()
    {
        myActionBar = getActionBar();
        if(myActionBar != null) {
            myActionBar.setDisplayShowTitleEnabled(false);
            myActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            myActionBar.setDisplayShowCustomEnabled(false);
            myActionBar.setHomeButtonEnabled(true);
            for (int i = 0; i != titleNumber; i++) {
                myTabs[i] = myActionBar.newTab().setText(titleTexts[i]).setTabListener(myTabListener);
                myActionBar.addTab(myTabs[i]);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (mSlidingMenu != null) {
                mSlidingMenu.toggle();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public ViewPager.OnPageChangeListener myPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            myActionBar.setSelectedNavigationItem(position);
            switch (position)
            {
                case 2:
                    mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    break;
                default:
                    mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public ActionBar.TabListener myTabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (tab == myTabs[0]) {
                myViewPager.setCurrentItem(0);
            } else if (tab == myTabs[1]) {
                myViewPager.setCurrentItem(1);
            } else if (tab == myTabs[2]) {
                myViewPager.setCurrentItem(2);
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    };
}
