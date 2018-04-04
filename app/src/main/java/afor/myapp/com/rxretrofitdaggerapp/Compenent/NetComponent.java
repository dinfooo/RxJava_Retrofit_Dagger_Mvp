package afor.myapp.com.rxretrofitdaggerapp.Compenent;

import javax.inject.Singleton;

import afor.myapp.com.rxretrofitdaggerapp.Module.AppModule;
import afor.myapp.com.rxretrofitdaggerapp.Module.NetModule;
import afor.myapp.com.rxretrofitdaggerapp.PaysList.PaysListActivity;
import afor.myapp.com.rxretrofitdaggerapp.PaysList.PaysListFragment;
import dagger.Component;

/**
 * Created by Mahdi Dammak on 23/03/2018.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    //faire la liaison dit a dagger quand va injecter les dependence dans PaysListFragment il faut appeler cette methode depuis PaysListFragment et envoyer PaysListFragment
    void injectPaysListActivity(PaysListActivity paysListActivity);


}
