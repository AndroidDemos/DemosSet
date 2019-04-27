package com.kky.example.mevent.d2;

import dagger.Module;
import dagger.Provides;

/*
 * @author Zeus
 * create at 2019/1/14 14:48
 * modify at 2019/1/14 14:48
 * modify because
 * description: TO FIT
 */
@Module
public class MainModule {
    //    @Provides
//    A providerA() {
//        return new A();
//    }
//
    @Provides
    B providerB() {
        return new B();
    }

    @Provides
    C providerC() {
        return new C();
    }
}
