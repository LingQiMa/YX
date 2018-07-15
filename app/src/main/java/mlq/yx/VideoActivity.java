package mlq.yx;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView register;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        register = (TextView) findViewById(R.id.rg_tv_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoActivity.this, Number.class);
                startActivity(intent);
            }
        });
        viewPager = (ViewPager) findViewById(R.id.rg_vp_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), getFragment()));
        initView();
        // initFragment();
        initVideoPath();
    }

    private List<Fragment> getFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Rg_one());
        fragments.add(new Rg_two());
        fragments.add(new Rg_three());
        fragments.add(new Rg_four());
        return fragments;
    }

    /* private void initFragment() {
       register = new Register();
    addFragmetn(nicheng);
     addFragmetn(login);
      addFragmetn(message);
     addFragmetn(number);
    addFragmetn(register);
    hideFragment(nicheng);
     hideFragment(login);
    hideFragment(message);
     hideFragment(number);
    hideFragment(register);
}*/
    private void initView(){
        videoView= (VideoView) findViewById(R.id.myvideoview);

    }
    private void initVideoPath(){
        videoView.setVideoPath(String.valueOf("android.resource://"+getPackageName()+"/"+R.raw.entrance_video));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
    }
   /* private void addFragmetn(Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentLayout,fragment);
        fragmentTransaction.commit();
    }
    /*private void hideFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }*/


}
