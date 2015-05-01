package de.regenistdoof.sporecounter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {


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
            default:
                return null;
        }
    }



    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

}