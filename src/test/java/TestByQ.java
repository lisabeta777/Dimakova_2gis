import Places.ItemsItem;
import Places.Response;
import Service.PlacesGet;
import Service.PlacesService;
import okhttp3.Headers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestByQ {

    //Поиск по query параметру q: название региона
    //Минимум — 3 символа
    //Регистр не имеет значения
    //Если передан этот параметр, все остальные параметры игнорируются

    PlacesGet placesGet = new PlacesService().getPlacesGet();

    @Test
    //Количество символов: 3
    public void getByQ_1() throws IOException {
        List<ItemsItem> retrofitPlace = placesGet.getByQ("Акт").execute().body().getItems();
        String result_1 = retrofitPlace.get(0).getName();
        String result_2 = retrofitPlace.get(1).getName();
        Assertions.assertEquals("Актау", result_1);
        Assertions.assertEquals("Актобе", result_2);
    }

    @Test
    //Количество символов: менее 3-x
    public void getByQ_2() throws IOException {
        Response  retrofitPlace = placesGet.getByQ("Мо").execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getError().getMessage();
        Assertions.assertEquals("Параметр 'q' должен быть не менее 3 символов", result);

    }

    @Test
    //Количество символов: более 3-ч
    public void getByQ_3() throws IOException {
       Response retrofitPlace = placesGet.getByQ("Москва").execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getItems().get(0).getName();
       Assertions.assertEquals("Москва", result);
    }

    @Test
    //Все верхним регистром
    public void getByQ_4() throws IOException {
        Response retrofitPlace = placesGet.getByQ("МАГНИТОГОРСК").execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getItems().get(0).getName();
        Assertions.assertEquals("Магнитогорск", result);
    }

    @Test
    //Все нижним регистром
    public void getByQ_5() throws IOException {
        Response  retrofitPlace = placesGet.getByQ("красноярск").execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getItems().get(0).getName();
        Assertions.assertEquals("Красноярск", result);
    }

    @Test
    //Если передан параметр q, все остальные параметры игнорируются
    public void getByQ_6() throws IOException {
        Response retrofitPlace = placesGet.getByAll("красноярск", "aktau", 6, 6).execute().body();
        assert retrofitPlace != null;
        String result   = retrofitPlace.getItems().get(0).getName();
        Assertions.assertEquals("Красноярск", result);
    }
}
