package com.example.minhaj.demo;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minhaj.demo.utils.Constants;
import com.example.minhaj.demo.utils.Prefs;
import com.example.minhaj.demo.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    //variables
    private Prefs prefs;

    //views
    private TextView tvTitle;
    private TextInputLayout tilUsername,tilPassword;
    private TextInputEditText etUsername,etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setupListeners();
    }

    private void init() {

        prefs = new Prefs(this);

        tvTitle = findViewById(R.id.title);

        tilUsername = findViewById(R.id.tilUserName);
        tilPassword = findViewById(R.id.tilPassword);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);

        tvTitle.setText(R.string.stringTitleLogin);
    }

    private void setupListeners() {

        etUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    tilUsername.setHint(getString(R.string.stringHintLoginUsernameActive));
                }else if (etUsername.getText().toString().trim().isEmpty()){
                    tilUsername.setHint(getString(R.string.stringHintLoginUsernameInactive));
                }
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    tilPassword.setHint(getString(R.string.stringHintLoginPasswordActive));
                }else if (etPassword.getText().toString().trim().isEmpty()){
                    tilPassword.setHint(getString(R.string.stringHintLoginPasswordInactive));
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        boolean valid = true;
        if (etUsername.getText().toString().trim().isEmpty()){
            tilUsername.setError(getString(R.string.stringErrorUsername));
            valid = false;
        }else if (etPassword.getText().toString().trim().isEmpty()){
            tilPassword.setError(getString(R.string.stringErrorPassword));
            valid = false;
        }

        if (valid){
            if (etUsername.getText().toString().trim().equals(Constants.ADMIN_USER_NAME) &&
                    etPassword.getText().toString().trim().equals(Constants.ADMIN_PASSWORD)){
                prefs.setBool(Constants.PREF_IS_ADMIN,true);
                prefs.setBool(Constants.PREF_IS_LOGIN,true);
                Utils.startMainActivity(this);

            }else if (etUsername.getText().toString().trim().equals(Constants.CLIENT_USER_NAME) &&
                    etPassword.getText().toString().trim().equals(Constants.CLIENT_USER_NAME)){
                prefs.setBool(Constants.PREF_IS_ADMIN,false);
                prefs.setBool(Constants.PREF_IS_LOGIN,true);
                Utils.startMainActivity(this);
            }else {
                Toast.makeText(this, R.string.stringErrorLogin, Toast.LENGTH_LONG).show();
            }
        }
    }
}
