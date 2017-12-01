package com.example.luffy.helloworld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScreenSliderActivity extends FragmentActivity {
    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slider);
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        //mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(NUM_PAGES + 1); //increase number of fragments to load
        nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(getItem(+1), true); //getItem(-1) for previous
                updateData();
            }
        });
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == NUM_PAGES - 1)
                {
                    nextButton.setText("Submit");
                } else {
                    nextButton.setText("Next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void updateData() {
        int position = mPager.getCurrentItem();
        if(position == NUM_PAGES- 1)
        {
            for (int i = 0; i < NUM_PAGES; i++) {
                View view = mPager.getChildAt(i);
                EditText meter1 = (EditText) (view.findViewById(R.id.firstMeter));
                EditText meter2 = (EditText) (view.findViewById(R.id.secondMeter));
                EditText dipValue = (EditText) (view.findViewById(R.id.dipValue));
                Log.d("haha", meter1.getText() + " " + meter2.getText() + " " + dipValue.getText());
            }
        }

    }

    private int getItem(int i) {
        return mPager.getCurrentItem() + i;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=   ScreenSlideFragment.newInstance("Tank number " + position);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}

