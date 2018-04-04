package afor.myapp.com.rxretrofitdaggerapp.PaysList;

import java.util.ArrayList;

import afor.myapp.com.rxretrofitdaggerapp.data.Pays;
import afor.myapp.com.rxretrofitdaggerapp.mvpBaseClasse.BasePresenter;
import afor.myapp.com.rxretrofitdaggerapp.mvpBaseClasse.BaseView;

/**
 * Created by Mahdi Dammak on 26/03/2018.
 */

public interface PaysListContract {

    interface View extends BaseView<Presenter>
    {
        void showPays(ArrayList<Pays> listPays);
    }

    interface Presenter extends BasePresenter
    {
        void loadPays();
    }
}
