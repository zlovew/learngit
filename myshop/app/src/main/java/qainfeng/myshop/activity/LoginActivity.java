package qainfeng.myshop.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import qainfeng.myshop.R;

public class  LoginActivity extends AppCompatActivity {
    private ImageView ivBack,ivQq,ivWx;
    private EditText etName,etPwd;
    private Button btLogin;
    private TextView tvForget,tvNewUser;
    private View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();
    }

    private void setListener() {
        mOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_login_login:
                        Toast.makeText(LoginActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_login_back:
                        finish();
                        break;
                    case R.id.tv_login_forget:
                        Toast.makeText(LoginActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_login_newUser:
                        Toast.makeText(LoginActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_login_qq:
                        Toast.makeText(LoginActivity.this, "5", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_login_wx:
                        Toast.makeText(LoginActivity.this, "6", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
        setViewListener(btLogin);
        setViewListener(ivBack);
        setViewListener(ivQq);
        setViewListener(ivWx);
        setViewListener(tvForget);
        setViewListener(tvNewUser);
    }

    private void initView() {
        etName= (EditText) findViewById(R.id.et_login_name);
        etPwd= (EditText) findViewById(R.id.et_login_pwd);
        CharSequence hint1 = etName.getHint();
        SpannableString ss1 = new SpannableString(hint1);//定义hint的值
        AbsoluteSizeSpan ass1 = new AbsoluteSizeSpan(15,true);//设置字体大小 true表示单位是sp
        ss1.setSpan(ass1, 0, ss1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        etName.setHint(new SpannedString(ss1));
        etName.setHintTextColor(Color.GREEN);
        CharSequence hint = etPwd.getHint();
        SpannableString ss2 = new SpannableString(hint);//定义hint的值
        AbsoluteSizeSpan ass2 = new AbsoluteSizeSpan(15,true);//设置字体大小 true表示单位是sp
        ss2.setSpan(ass2, 0, ss2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        etPwd.setHint(new SpannedString(ss2));
        etPwd.setHintTextColor(Color.GREEN);

        ivBack= (ImageView) findViewById(R.id.iv_login_back);
        ivQq= (ImageView) findViewById(R.id.iv_login_qq);
        ivWx= (ImageView) findViewById(R.id.iv_login_wx);
        btLogin= (Button) findViewById(R.id.bt_login_login);
        tvForget= (TextView) findViewById(R.id.tv_login_forget);
        tvNewUser= (TextView) findViewById(R.id.tv_login_newUser);
    }

    public void setViewListener(View v) {
        v.setOnClickListener(mOnClickListener);
    }
}
