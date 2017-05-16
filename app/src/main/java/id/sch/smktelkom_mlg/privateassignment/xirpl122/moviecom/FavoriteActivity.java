package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.db.FavoriteFragment;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = new FavoriteFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commitNow();

    }

}
