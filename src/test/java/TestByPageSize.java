import Places.ItemsItem;
import Places.Response;
import Service.PlacesGet;
import Service.PlacesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestByPageSize {

    //Поиск по query параметру page_size: количество элементов на странице
    //Может принимать значения: 5, 10, 15
    //Значение по умолчанию — 15

    PlacesGet placesGet = new PlacesService().getPlacesGet();

    @Test
    //Значение параметра: 5
    public void getByPageSize_1() throws IOException {
        Response retrofitPlace = placesGet.getByPageSize("5").execute().body();
        assert retrofitPlace != null;
        int result = retrofitPlace.getItems().size();
        Assertions.assertEquals(5, result);
    }

    @Test
    //Значение параметра: 10
    public void getByPageSize_2() throws IOException {
        Response retrofitPlace = placesGet.getByPageSize("10").execute().body();
        assert retrofitPlace != null;
        int result = retrofitPlace.getItems().size();
        Assertions.assertEquals(10, result);
    }

    @Test
    //Значение параметра: 15
    public void getByPageSize_3() throws IOException {
        Response retrofitPlace = placesGet.getByPageSize("15").execute().body();
        assert retrofitPlace != null;
        int result = retrofitPlace.getItems().size();
        Assertions.assertEquals(15, result);
    }

    @Test
    //Проверка условия: page_size не может принимать на вход значения, отличные от: 5, 10, 15
    public void getByPageSize_4() throws IOException {
        Response retrofitPlace = placesGet.getByPageSize("6").execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getError().getMessage();
        Assertions.assertEquals("Параметр 'page_size' может быть одним из следующих значений: 5, 10, 15", result);
    }

    @Test
    //Значение параметра: по умолчанию
    public void getByPageSize_5() throws IOException {
        Response retrofitPlace = placesGet.getByPageSize(null).execute().body();
        Response retrofitPlace_expected = placesGet.getByPageSize("15").execute().body();
        Assertions.assertEquals(retrofitPlace_expected, retrofitPlace);
    }
}
