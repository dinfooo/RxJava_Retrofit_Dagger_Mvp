package afor.myapp.com.rxretrofitdaggerapp.PaysList;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

import afor.myapp.com.rxretrofitdaggerapp.data.retrofitEntity.RetourJson;
import afor.myapp.com.rxretrofitdaggerapp.data.Pays;
import afor.myapp.com.rxretrofitdaggerapp.data.source.PaysServiceImp;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Mahdi Dammak on 26/03/2018.
 */

public class PaysListPresenter implements PaysListContract.Presenter {
    PaysListContract.View mPaysListView;
    PaysServiceImp mPaysServiceImp;
    @NonNull
    private CompositeDisposable mCompositeDisposable=new CompositeDisposable();

    public PaysListPresenter(PaysServiceImp paysServiceImp, PaysListContract.View paysListView) {
        this.mPaysServiceImp = checkNotNull(paysServiceImp, "paysServiceImp cannot be null");
        this.mPaysListView = checkNotNull(paysListView, "paysListView cannot be null!");
        mPaysListView.setPresenter(this);
    }

    @Override
    public void loadPays() {
        mCompositeDisposable.clear();
        Observable<RetourJson> observable = mPaysServiceImp.getAllPays();
        DisposableObserver<RetourJson> observer = new DisposableObserver<RetourJson>() {
            @Override
            public void onNext(RetourJson value) {
                Log.d(PaysListActivity.class.getSimpleName(), "ws Retour : " + value.toString());
                ArrayList<Pays> listPays = value.getRestResponse().getResult();
                mPaysListView.showPays(listPays);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable disposable = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer);

        mCompositeDisposable.add(disposable);

    }


    @Override
    public void subscribe() {
        loadPays();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
