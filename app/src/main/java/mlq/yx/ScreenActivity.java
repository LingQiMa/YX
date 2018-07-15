package mlq.yx;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    private  RadioGroup radioGroup;
    private  ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
            actionBar.hide();
        initView();
        initListener();
    }
    private void initView(){
        radioGroup= (RadioGroup) findViewById(R.id.main_rg_radioGroup);
        viewPager= (ViewPager) findViewById(R.id.main_vp_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), getListFragment()));

    }


    private List<Fragment> getListFragment(){
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new yixin());
        fragments.add(new faxian());
        fragments.add(new pengbei());
        fragments.add(new haoyou());
        fragments.add(new wo());
        return fragments;
    }

    private void initListener(){
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.main_rb_yixin);
                break;
            case 1:
                radioGroup.check(R.id.main_rb_faxian);
                break;
            case 2:
                radioGroup.check(R.id.main_rb_pengbei);
                break;
            case 3:
                radioGroup.check(R.id.main_rb_haoyou);
                break;
            case 4:
                radioGroup.check(R.id.main_rb_wo);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_rb_yixin:
                viewPager.setCurrentItem(0);
                break;
            case R.id.main_rb_faxian:
                viewPager.setCurrentItem(1);
                break;
            case R.id.main_rb_pengbei:
                viewPager.setCurrentItem(2);
                break;
            case R.id.main_rb_haoyou:
                viewPager.setCurrentItem(3);
                break;
            case R.id.main_rb_wo:
                viewPager.setCurrentItem(4);
                break;
        }
    }
}
