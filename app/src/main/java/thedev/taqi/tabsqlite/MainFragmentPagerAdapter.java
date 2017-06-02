package thedev.taqi.tabsqlite;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import thedev.taqi.tabsqlite.FragmentPage1;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "REPORT", "UPDATE", "NEWS" };
    private Context context;
    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    @Override
    public Fragment getItem(int arg0) {
        Bundle data = new Bundle();
        switch(arg0){
            /** tab1 is selected */
            case 0:
                FragmentPage1 fragmentpage1 = new FragmentPage1();
                return fragmentpage1;
            /** tab2 is selected */
            case 1:
                FragmentPage2 fragmentpage2 = new FragmentPage2();
                return fragmentpage2;
            /** tab3 is selected */
            case 2:
                FragmentPage3 fragmentpage3 = new FragmentPage3();
                return fragmentpage3;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
