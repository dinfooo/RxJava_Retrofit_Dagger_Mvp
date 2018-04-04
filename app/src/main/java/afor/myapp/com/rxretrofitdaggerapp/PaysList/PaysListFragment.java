package afor.myapp.com.rxretrofitdaggerapp.PaysList;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import afor.myapp.com.rxretrofitdaggerapp.data.Pays;
import afor.myapp.com.rxretrofitdaggerapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * Created by Mahdi Dammak on 26/03/2018.
 */
public class PaysListFragment extends Fragment implements PaysListContract.View {

    PaysListContract.Presenter mPresenter;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    public PaysListFragment() {
        // Required empty public constructor
    }

    public static PaysListFragment newInstance() {
        return new PaysListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pays_list, container, false);
        ButterKnife.bind(this, rootView);
        initialisation();
        mPresenter.loadPays();
        return rootView;
    }

    public void initialisation() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void showPays(ArrayList<Pays> listPays) {
        PaysListAdapter paysListAdapter = new PaysListAdapter(getActivity().getApplicationContext(), listPays, new PaysListAdapter.OnItemClickListener() {
            @Override
            public void onClick(Pays Item) {
                Toast.makeText(getActivity().getApplicationContext(), Item.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(paysListAdapter);
        Log.d(PaysListActivity.class.getSimpleName(), "liste des pays : " + listPays.toString());
    }

    @Override
    public void setPresenter(@NonNull PaysListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }
}
