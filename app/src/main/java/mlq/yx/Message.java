package mlq.yx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 2017/11/16.
 */

public class Message extends Activity implements View.OnClickListener{
    private ImageView back;
    private EditText etone;
    private EditText ettwo;
    private EditText etthree;
    private EditText etfour;
    private EditText etfive;
    private TextView zhushi;
    private String number;
    private TextView shoujihao;
    private String yanzhengma;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        init();
        initListener();
        Intent intent=getIntent();
        number=intent.getStringExtra("number");
        shoujihao.setText(number);
        yanzhengma = intent.getStringExtra("yanzhengma");

    }
    private void init(){
        back = (ImageView) findViewById(R.id.msg_iv_back);
        etone = (EditText) findViewById(R.id.msg_et_one);
        ettwo = (EditText) findViewById(R.id.msg_et_two);
        etthree = (EditText) findViewById(R.id.msg_et_three);
        etfour = (EditText) findViewById(R.id.msg_et_four);
        etfive= (EditText) findViewById(R.id.msg_et_five);
        shoujihao = (TextView) findViewById(R.id.msg_tv_number);
    }
    private void initListener(){
        back.setOnClickListener(this);
        etone.addTextChangedListener(textWather);
        ettwo.addTextChangedListener(textWather);
        etthree.addTextChangedListener(textWather);
        etfour.addTextChangedListener(textWather);
        ettwo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    etone.setText(null);
                    etone.requestFocus();
                    return true;
                }
                return false;
            }
        });
        etthree.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    ettwo.setText(null);
                    ettwo.requestFocus();
                    return true;
                }
                return false;
            }
        });
       etfour.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    etthree.setText(null);
                    etthree.requestFocus();
                    return true;
                }
                return false;
            }
        });
       etfive.setOnKeyListener(new View.OnKeyListener() {
            @Override
           public boolean onKey(View v, int keyCode, KeyEvent event) {
               if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    etfour.setText(null);
                etfour.requestFocus();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msg_iv_back:
                onBackPressed();
                break;
        }
    }
    private TextWatcher textWather=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().length() == 1) {
                if (etone.isFocused()) {
                    etone.clearFocus();
                   ettwo.requestFocus();
                }
                else if (ettwo.isFocused()) {
                    ettwo.clearFocus();
                    etthree.requestFocus();
                }
                else if (etthree.isFocused()) {
                    etthree.clearFocus();
                    etfour.requestFocus();
                }
                else if (etfour.isFocused()) {
                    etfour.clearFocus();
                    etfive.requestFocus();
                }

            }
            String Code = (etone.getText().toString() + ettwo.getText().toString() + etthree.getText().toString() + etfour.getText().toString());
           if (Code.equals(yanzhengma)&& etfive.isFocused()) {
                Intent intent2 = new Intent(Message.this, Nicheng.class);
               intent2.putExtra("number", number);
                startActivity(intent2);
            }
            else if (etfive.isFocused() && !Code.equals(yanzhengma)) {
                Toast.makeText(Message.this, "您输入的验证码有误", Toast.LENGTH_SHORT).show();
            }


        }
    };
}
