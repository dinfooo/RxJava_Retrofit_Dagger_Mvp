package afor.myapp.com.rxretrofitdaggerapp.PaysList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import afor.myapp.com.rxretrofitdaggerapp.Util.ActivityUtils;
import afor.myapp.com.rxretrofitdaggerapp.MyApp;
import afor.myapp.com.rxretrofitdaggerapp.R;
import afor.myapp.com.rxretrofitdaggerapp.data.source.PaysServiceImp;

/**
 * Created by Mahdi Dammak on 22/03/2018.
 */

public class PaysListActivity extends AppCompatActivity {

    private PaysListPresenter mPaysListPresenter;
    @Inject
    PaysServiceImp paysServiceImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //faire la liaison dit a dagger quand va injecter les dependence dans PaysListActivity
        ((MyApp) getApplication()).getComponent().injectPaysListActivity(this);

        PaysListFragment tasksFragment =
                (PaysListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = PaysListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }

        // Create the presenter
        mPaysListPresenter = new PaysListPresenter(paysServiceImp, tasksFragment);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
