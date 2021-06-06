package Service;

import Places.ItemsItem;
import Places.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface PlacesGet {

    @GET("/1.0/regions")
    Call<Response> getByQ(@Query("q") String q);

    @GET("/1.0/regions")
    Call<Response> getByCountryCode(@Query("country_code") String country_code);

    @GET("/1.0/regions")
    Call<Response> getByPage(@Query("page") String page);

    @GET("/1.0/regions")
    Call<Response> getByPageSize(@Query("page_size") String page_size);

    @GET("/1.0/regions")
    Call<Response> getByAll(@Query("q") String q,
                                 @Query("country_code") String country_code,
                                 @Query("page") int page,
                                 @Query("page_size") int page_size );
}
