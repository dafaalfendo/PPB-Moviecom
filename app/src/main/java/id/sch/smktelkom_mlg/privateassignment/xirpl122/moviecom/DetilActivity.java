package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class DetilActivity extends AppCompatActivity implements Serializable {

    public TextView tvTitle;
    public TextView tvYear;
    public TextView tvId;
    public TextView tvPopularity;
    public ImageView ivDetail;
    public String url;
    public String imageURL;
    boolean isPressed = true;
    FloatingActionButton fab;
    private Integer mPostkey = null;
    private String jenis = null;
    private String URL_DATA = "https://api.themoviedb.org/3/genre/movie/list?api_key=cecc9162a02c65190851eebec7025119&language=en-US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPostkey = getIntent().getExtras().getInt("id");
        jenis = getIntent().getExtras().getString("jenis");

        if (jenis.equals("Action")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/28/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("Adventure")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/12/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("Crime")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/80/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("Family")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/10751/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("History")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/36/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("Horor")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/27/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        } else if (jenis.equals("War")) {
            URL_DATA = "https://api.themoviedb.org/3/genre/10752/movies?api_key=cecc9162a02c65190851eebec7025119&language=en-US&include_adult=false&sort_by=created_at.asc";
        }

        loadRecyclerViewData();

        tvTitle = (TextView) findViewById(R.id.textViewHead);
        tvYear = (TextView) findViewById(R.id.textViewYear);
        tvId = (TextView) findViewById(R.id.textViewId);
        tvPopularity = (TextView) findViewById(R.id.textViewType);
//        textViewReview = (TextView) findViewById(R.id.textViewReview);
        ivDetail = (ImageView) findViewById(R.id.imageViewDetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        fab = (FloatingActionButton) findViewById(R.id.fab);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isPressed) {
//                    doSave();
//                    Snackbar.make(view, "Berhasil ditambahkan ke favorit", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                } else {
//
//                    Snackbar.make(view, "Artikel favorit anda", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//                isPressed = !isPressed;

            }
        });
    }

//    private void doSave() {
////        String judul = textViewHeadet.getText().toString();
////        String deskripsi = textViewDescet.getText().toString();
////        String urlgambar = urlGambar;
////        favouriteItem = new FavouriteItem(judul, deskripsi, urlgambar);
////        favouriteItem.save();
//
//        String imageurl = imageURL;
//        String title = textViewTitleet.getText().toString();
//        String year = textViewYearet.getText().toString();
//        heroDBItem = new HeroDBItem(imageurl, title, year);
//        heroDBItem.save();
//    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("results");
                            JSONObject o = array.getJSONObject(mPostkey);

                            tvTitle.setText(o.getString("title"));
                            tvYear.setText(o.getString("release_date"));
                            tvId.setText("Popularity : " + o.getString("popularity"));
                            tvPopularity.setText(o.getString("overview"));
//                            url = o.getJSONObject("link").getString("url");

                            Glide
                                    .with(DetilActivity.this)
                                    .load("http://image.tmdb.org/t/p/w500" + o.getString("poster_path"))
                                    .into(ivDetail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
