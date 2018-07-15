package mlq.yx;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
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

public class Nicheng extends Activity implements TextWatcher ,View.OnClickListener{
    private EditText password;
    private Button next;
    private String number;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nicheng);
        init();
        initListener();
        Intent intent = getIntent();
        number = intent.getStringExtra("number");
    }
    private void init(){
        password = (EditText) findViewById(R.id.nc_et_password);
        next = (Button) findViewById(R.id.nc_btn_next);
        next.setEnabled(false);
    }
    private void initListener(){
        password.addTextChangedListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (password.getText().length()>=8) {
            next.setBackgroundResource(R.drawable.green_button);
            next.setEnabled(true);
            next.setTextColor(Color.WHITE);
        } else if (s.equals("")) {
            next.setBackgroundResource(R.drawable.button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nc_btn_next:
                Intent intent2 = new Intent(Nicheng.this, Login.class);
                intent2.putExtra("number", number);
                intent2.putExtra("password", password.getText().toString());
                startActivity(intent2);
        }
    }
}
