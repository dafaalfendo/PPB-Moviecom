package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    public TextView tvTest;
    String view = "Aplikasi untuk melihat daftar film dalam beberapa kategori, serta memberika deskripsi dari masing-masing film. Penguna juga" +
            "dapat memasukkan film ke daftar film favorit.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvTest = (TextView) findViewById(R.id.textView);
        tvTest.setText(view);

    }
}
