package com.hrisko.quotes.diconfig;

import android.app.Application;

import com.hrisko.quotes.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        ParsersModule.class,
        HttpModule.class,
        RepositoriesModule.class,
        ServicesModule.class,
        ValidatorModule.class,
        AsyncModule.class,
        ViewsModule.class
})
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
