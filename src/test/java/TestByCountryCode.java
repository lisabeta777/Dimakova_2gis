import Places.Response;
import Service.PlacesGet;
import Service.PlacesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestByCountryCode {

    //Поиск по query параметры country_code: код страны для фильтрации
    //Может принимать значения: ru, kg, kz, cz
    //По умолчанию отображаются регионы из всех стран

    PlacesGet placesGet = new PlacesService().getPlacesGet();

    @Test
    //Проверка условия: country_code может принимать на вход значение ru
    public void getByCountryCode_1() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("ru").execute().body();
        assert retrofitPlace != null;
        long size = retrofitPlace.getItems().size();
        for(int i = 0; i < size; i++) {
            String result   = retrofitPlace.getItems().get(i).getCountry().getCode();
            Assertions.assertEquals("ru", result);
        }
    }

    @Test
    //Проверка условия: country_code может принимать на вход значение kg
    public void getByCountryCode_2() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("kg").execute().body();
        assert retrofitPlace != null;
        long size = retrofitPlace.getItems().size();
        for(int i = 0; i < size; i++) {
            String result   = retrofitPlace.getItems().get(i).getCountry().getCode();
            Assertions.assertEquals("kg", result);
        }
    }

    @Test
    //Проверка условия: country_code может принимать на вход значение kz
    public void getByCountryCode_3() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("kz").execute().body();
        assert retrofitPlace != null;
        long size = retrofitPlace.getItems().size();
        for(int i = 0; i < size; i++) {
            String result   = retrofitPlace.getItems().get(i).getCountry().getCode();
            Assertions.assertEquals("kz", result);
        }
    }

    @Test
    //Проверка условия: country_code может принимать на вход значение cz
    public void getByCountryCode_4() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("cz").execute().body();
        assert retrofitPlace != null;
        long size = retrofitPlace.getItems().size();
        for(int i = 0; i < size; i++) {
            String result   = retrofitPlace.getItems().get(i).getCountry().getCode();
            Assertions.assertEquals("cz", result);
        }
    }

    @Test
    //Проверка условия: country_code не может принимать на вход значения, отличные от: ru, kg, kz, cz
    public void getByCountryCode_5() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("eng").execute().body();
        String errorMessage = retrofitPlace.getError().getMessage();
        Assertions.assertEquals("Параметр 'country_code' может быть одним из следующих значений: ru, kg, kz, cz", errorMessage);
    }

    @Test
    //Проверка условия: country_code не может принимать на вход значения, отличные от: ru, kg, kz, cz
    public void getByCountryCode_6() throws IOException {
        Response retrofitPlace = placesGet.getByCountryCode("ua").execute().body();
        String errorMessage = retrofitPlace.getError().getMessage();
        Assertions.assertEquals("Параметр 'country_code' может быть одним из следующих значений: ru, kg, kz, cz", errorMessage);
    }

    @Test
    //Проверка условия: по умолчанию отображаются регионы из всех стран
    public void getByCountryCode_7() throws IOException {
        Response retrofitPlaceAll = placesGet.getByCountryCode(null).execute().body();
        long size = retrofitPlaceAll.getItems().size();

        ArrayList<String> countryAll = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String code = retrofitPlaceAll.getItems().get(i).getCountry().getCode();
            countryAll.add(code);
        }
        boolean b = countryAll.contains("ru") & countryAll.contains("kz") & countryAll.contains("kg") & countryAll.contains("cz");
        Assertions.assertEquals(true, b);
    }

}

