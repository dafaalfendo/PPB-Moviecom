package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.History;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.R;

/**
 * Created by User on 13/05/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<HistoryListItem> historyListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public HistoryAdapter(List<HistoryListItem> historyListItems, Context context) {
        this.historyListItems = historyListItems;
        this.context = context;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, final int position) {
        final HistoryListItem historyListItem = historyListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.tvTitle.setText(historyListItem.getTitle());
        holder.tvPop.setText(historyListItem.getPopularity());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + historyListItem.getImage())
                .into(holder.ivImage);

        holder.llLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

//                Intent singleBlogIntent = new Intent(context, TechnologyDetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
//                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
//                context.startActivity(singleBlogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public LinearLayout llLinear;
        public ImageView ivImage;
        public TextView tvPop;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewHistory);
            llLinear = (LinearLayout) itemView.findViewById(R.id.LinearLayoutHistory);
            ivImage = (ImageView) itemView.findViewById(R.id.imageViewHistory);
            tvPop = (TextView) itemView.findViewById(R.id.textViewHistoryPopularity);
        }
    }
}
