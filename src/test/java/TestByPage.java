import Places.ItemsItem;
import Places.Response;
import Service.PlacesGet;
import Service.PlacesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestByPage {

    //Поиск по query параметры page: порядковый номер страницы
    //Минимальное значение — 1
    //Значение по умолчанию — 1

    PlacesGet placesGet = new PlacesService().getPlacesGet();

    @Test
    //Значение параметра: 0
    public void getByPage_1() throws IOException {
        int retrofitPlace = placesGet.getByPage("0").execute().code();
        Assertions.assertEquals(500, retrofitPlace);
    }

    @Test
    //Значение параметра: 1
    public void getByPage_2() throws IOException {
        int retrofitPlace = placesGet.getByPage("1").execute().code();
        Assertions.assertEquals(200, retrofitPlace);
    }

    @Test
    //Значение параметра: 2
    public void getByPage_3() throws IOException {
        int retrofitPlace = placesGet.getByPage("2").execute().code();
        Assertions.assertEquals(200, retrofitPlace);
    }

    @Test
    //Значение по умолчанию = 1
    public void getByPage_4() throws IOException {
        Response retrofitPlace_expected = placesGet.getByPage("1").execute().body();
        Response retrofitPlace = placesGet.getByPage(null).execute().body();

        assert retrofitPlace != null;
        long size = retrofitPlace.getItems().size();
        assert retrofitPlace_expected != null;
        long size_expected = retrofitPlace_expected.getItems().size();

            for (int i = 0; i < size; i++) {
                int result_expected = retrofitPlace_expected.getItems().get(i).getId();
                int result = retrofitPlace.getItems().get(i).getId();
                Assertions.assertEquals(result_expected, result);
            }
        Assertions.assertEquals(size_expected, size);
    }

}
