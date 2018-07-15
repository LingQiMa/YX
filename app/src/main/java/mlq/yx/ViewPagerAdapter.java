package mlq.yx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
