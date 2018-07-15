package mlq.yx;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register extends Fragment {
    private ViewPager viewPager;
    private View view;
    private TextView registerBtn;
    private TextView loginBtn;
    private VideoActivity activity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView");
        view = inflater.inflate(R.layout.register, null);
        registerBtn= (TextView) view.findViewById(R.id.rg_tv_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getId()) {
                    case R.id.rg_tv_register:
                        Intent intent = new Intent(getActivity(), Number.class);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "llllll", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        init();
        return view;
    }



    private void init(){
        viewPager= (ViewPager) view.findViewById(R.id.rg_vp_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager(),getFragment()));
    }
    private List<Fragment> getFragment(){
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new Rg_one());
        fragments.add(new Rg_two());
        fragments.add(new Rg_three());
        fragments.add(new Rg_four());
        return fragments;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "on Start");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG", "on Attach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "on Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "on Pause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "on Destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG", "on DestroyView");
    }


}
