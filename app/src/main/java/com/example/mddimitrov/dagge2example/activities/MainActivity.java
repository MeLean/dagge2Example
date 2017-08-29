package com.example.mddimitrov.dagge2example.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mddimitrov.dagge2example.R;
import com.example.mddimitrov.dagge2example.dagger_components.DaggerSharedPreferencesComponent;
import com.example.mddimitrov.dagge2example.dagger_modules.AppModule;
import com.example.mddimitrov.dagge2example.dagger_modules.SharedPreferencesModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    SharedPreferences mSharedPreferences;

    public static final String SHARED_PREF_KEY ="Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerSharedPreferencesComponent
                .builder()
                .appModule(new AppModule(getApplication())) // This also corresponds to the name of your module: %component_name%Module
                .sharedPreferencesModule(new SharedPreferencesModule())
                .build()
                .inject(this);

        mSharedPreferences.edit().putBoolean(SHARED_PREF_KEY, true).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mSharedPreferences.getBoolean(SHARED_PREF_KEY, false)){
            Toast.makeText(this, "SharedPreferences has been injected by Dagger lib!", Toast.LENGTH_SHORT).show();
        }
    }
}
