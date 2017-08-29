package com.example.mddimitrov.dagge2example.dagger_components;

import com.example.mddimitrov.dagge2example.activities.MainActivity;
import com.example.mddimitrov.dagge2example.dagger_modules.AppModule;
import com.example.mddimitrov.dagge2example.dagger_modules.SharedPreferencesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, SharedPreferencesModule.class})
public interface SharedPreferencesComponent {
    void inject(MainActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}