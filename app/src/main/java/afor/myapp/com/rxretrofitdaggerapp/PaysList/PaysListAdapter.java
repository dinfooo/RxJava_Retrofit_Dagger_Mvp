package afor.myapp.com.rxretrofitdaggerapp.PaysList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import afor.myapp.com.rxretrofitdaggerapp.R;
import afor.myapp.com.rxretrofitdaggerapp.data.Pays;

public class PaysListAdapter extends RecyclerView.Adapter<PaysListAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<Pays> data;
    private Context context;

    public PaysListAdapter(Context context, List<Pays> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public PaysListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_pays, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PaysListAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.name.setText(data.get(position).getName());
        holder.alpha2Code.setText(data.get(position).getAlpha2_code());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Pays Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, alpha2Code;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            alpha2Code = itemView.findViewById(R.id.alpha2_code);

        }


        public void click(final Pays cityListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }


}
