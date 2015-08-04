package de.regenistdoof.sporecounter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {



   // final int PAGE_COUNT = 3;
   // private String tabTitles[] = new String[]{"Counter", "Calculations", "Results"};

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Counter", "Calculations"};
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentCounter.newInstance(0);
            case 1:
                return FragmentCalculations.newInstance(1);
  //          case 2:
  //            return FragmentResults.newInstance(2);
            default:
                return null;
        }
    }



    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }




}