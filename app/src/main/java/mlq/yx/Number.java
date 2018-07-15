package mlq.yx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class Number extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    private ImageView back;
    private EditText number;
    private Button next;
    private String shoujihao;
    private PickerScrollView pickerScrollView;
    private RelativeLayout relativeLayout;
    private List<Pickers> list;
    private String[] id;
    private String[] areaId;
    private String[] name;
    private TextView country;

    private CheckBox checkBox;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number);
        init();
        initListener();
        initData();
    }
    private void init(){
        back = (ImageView) findViewById(R.id.nb_iv_back);
        number = (EditText) findViewById(R.id.nb_et_shoujihao);
        next = (Button) findViewById(R.id.nb_btn_next);
        next.setEnabled(false);
        pickerScrollView = (PickerScrollView) findViewById(R.id.pickerScrollView);
        relativeLayout = (RelativeLayout) findViewById(R.id.picker_rel);
        country = (TextView) findViewById(R.id.nb_tv_country);
        checkBox = (CheckBox) findViewById(R.id.nb_iv_go);

    }
    private void initListener(){
        back.setOnClickListener(this);
        next.setOnClickListener(this);
        number.addTextChangedListener(textWatcher);
        pickerScrollView.setOnSelectListener(pickerListener);
        checkBox.setOnCheckedChangeListener(this);
       relativeLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nb_iv_back:
                onBackPressed();
                break;
            case R.id.nb_btn_next:
                String randomText = RandomNumber.createRandomText();
                Toast.makeText(Number.this, "您的验证码为"+randomText, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Number.this, Message.class);
                shoujihao=number.getText().toString();
                intent.putExtra("number", shoujihao);
                intent.putExtra("yanzhengma",randomText);
                startActivity(intent);
                break;
        }
    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (number.getText().length() == 11) {
                next.setBackgroundResource(R.drawable.green_button);
                next.setEnabled(true);
                next.setTextColor(Color.WHITE);
            }
        }
    };
    private void initData(){
        list=new ArrayList<Pickers>();
        id=new String[]{"1","2","3","4","5","6"};
        name=new String[]{"中国","美国","日本","英国","德国","韩国"};
        areaId=new String[]{"86","01","81","44","349","82"};
        for (int i=0;i<name.length;i++){
            list.add(new Pickers(name[i],id[i]));
        }
        //设置数据，默认选择第一条
        pickerScrollView.setData(list);
        pickerScrollView.setSelected(0);
    }
    private String s;
    PickerScrollView.onSelectListener pickerListener=new PickerScrollView.onSelectListener(){
        @Override
        public void onSelect(Pickers pickers){
            s=pickers.getShowConetnt().toString().trim();
            if(s.equals("中国")){
               // contryNumber.setText("+86");
                country.setText("中国");

            }
            if(s.equals("美国")){
               // contryNumber.setText("+01");
                country.setText("美国");

            }
            if(s.equals("日本")){
               // contryNumber.setText("+81");
                country.setText("日本");

            }
            if(s.equals("英国")){
               // contryNumber.setText("+44");
                country.setText("英国");

            }
            if(s.equals("德国")){
               // contryNumber.setText("+349");
                country.setText("德国");

            }
            if(s.equals("韩国")){
             //   contryNumber.setText("+82");
                country.setText("韩国");

            }
        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            relativeLayout.setVisibility(View.VISIBLE);
        }else relativeLayout.setVisibility(View.INVISIBLE);
    }
}
