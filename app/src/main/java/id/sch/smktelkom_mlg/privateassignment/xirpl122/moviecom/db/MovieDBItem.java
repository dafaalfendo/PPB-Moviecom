package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.db;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by User on 15/05/2017.
 */

public class MovieDBItem extends SugarRecord implements Serializable {
    public String imageUrl;
    public String title;
    public String year;
    public String jenis;
    public String desc;
    public int id;

    public MovieDBItem() {

    }

    public MovieDBItem(String imageUrl, String title, String year, String jenis, String desc) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.year = year;
        this.jenis = jenis;
        this.desc = desc;
    }
}
