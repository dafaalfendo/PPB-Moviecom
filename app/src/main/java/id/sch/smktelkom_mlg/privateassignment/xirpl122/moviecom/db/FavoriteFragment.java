package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.db;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    ArrayList<MovieDBItem> fList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFavorite);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fList = new ArrayList<>();

        adapter = new MovieDBAdapter(fList, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        fList.addAll(MovieDBItem.listAll(MovieDBItem.class));
        adapter.notifyDataSetChanged();

        return view;
    }

}
