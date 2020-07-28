package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import com.tommyhasselman.termsconditions.playServices.Account;

public class BaseActivity extends AppCompatActivity {

    Controller cont = ((Controller) this.getApplication());

    @Override
    protected void onStart() {
        super.onStart();
        Account.signInSilently(this, cont);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
