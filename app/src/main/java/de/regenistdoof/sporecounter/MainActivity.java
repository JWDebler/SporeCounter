package de.regenistdoof.sporecounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    ViewPager viewPager;

    SampleFragmentPagerAdapter adapter;

    private FragmentCalculations fragcalc;

    // get latest count from FragmentCounter and call updateCall method in FragmentCalculations
    public void setLastCount(int count) {
        ((FragmentCalculations)fragcalc).updateCall(count);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragcalc = new FragmentCalculations();

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);


        // Give the SlidingTabLayout the ViewPager
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        // Center the tabs in the layout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
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

}
