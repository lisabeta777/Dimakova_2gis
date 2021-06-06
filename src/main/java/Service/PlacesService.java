package Service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PlacesService {

    private PlacesGet placesGet;

    public final PlacesGet getPlacesGet() {
            if (placesGet == null) {
                Retrofit retrofit = new Retrofit.Builder().
                        baseUrl(" https://regions-test.2gis.com/")
                        .addConverterFactory(JacksonConverterFactory.create()).build();
                placesGet = retrofit.create(PlacesGet.class);
            }
            return placesGet;
        }
}
