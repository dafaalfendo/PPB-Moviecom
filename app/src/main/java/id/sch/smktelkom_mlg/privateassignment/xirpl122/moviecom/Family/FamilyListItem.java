package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.Family;

import java.io.Serializable;

/**
 * Created by User on 13/05/2017.
 */

public class FamilyListItem implements Serializable {
    private String title;
    private String popularity;
    private String image;

    public FamilyListItem(String title, String popularity, String image) {
        this.title = title;
        this.popularity = popularity;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getImage() {
        return image;
    }
}
