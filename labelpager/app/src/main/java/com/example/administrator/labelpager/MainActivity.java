package com.example.administrator.labelpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.labelpager.com.pager.label.PagerAdapter;
import com.example.administrator.labelpager.com.pager.label.LabelPager;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private LabelPager toptitlepage;
    private ViewPager viewPager;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toptitlepage = (LabelPager) findViewById(R.id.toptitlepage);
        viewPager = (ViewPager) findViewById(R.id.jazzviewpager);
        testData();
        initJazzPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void testData() {
        titles.add("IOS");
        titles.add("Android");
        titles.add("GOOGLE");
        titles.add("PS");
        titles.add("PHP");
        titles.add("PHP");
        titles.add("PHP");
        titles.add("PHP");
        for (int i = 0; i < 8; i++) {

            views.add(new View(this));
        }
    }

    private void initJazzPager() {
        toptitlepage.addTitle(titles);
        toptitlepage.topTitColorMove(0);
        PagerAdapter jazzPager = new PagerAdapter(this, views);
        viewPager.setAdapter(jazzPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toptitlepage.topTitColorMove(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        toptitlepage.setOnTabLinstener(new LabelPager.onTabLinstener() {
            @Override
            public void onItemClick(int index) {
                viewPager.setCurrentItem(index);
            }
        });
    }
}
