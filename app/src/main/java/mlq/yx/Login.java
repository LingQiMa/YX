package mlq.yx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lenovo on 2017/11/16.
 */

public class Login extends Activity implements View.OnClickListener,TextWatcher{
    private Button next;
    private EditText zhanghao;
    private EditText password;
    private String number;
    private String mima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent intent=getIntent();
        number=intent.getStringExtra("number");
        mima=intent.getStringExtra("password");
        init();
        initListener();
    }
    private void init(){
        next = (Button) findViewById(R.id.log_btn_login);
        next.setEnabled(false);
        zhanghao = (EditText) findViewById(R.id.log_et_number);
        password = (EditText) findViewById(R.id.log_et_psd);

    }
    private void initListener(){
        next.setOnClickListener(this);
        password.addTextChangedListener(this);
        zhanghao.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_btn_login:
                Intent intent2 = new Intent(this, ScreenActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (password.getText().toString().equals(mima) && zhanghao.getText().toString().equals(number)) {
            next.setEnabled(true);
            next.setBackgroundResource(R.drawable.green_button);
        }
    }
}
