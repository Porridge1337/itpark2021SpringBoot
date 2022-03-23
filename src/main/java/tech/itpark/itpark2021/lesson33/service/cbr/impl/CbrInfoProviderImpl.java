package tech.itpark.itpark2021.lesson33.service.cbr.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import tech.itpark.itpark2021.lesson33.config.SpringConfiguration;
import tech.itpark.itpark2021.lesson33.dto.CbrDailyInfoDto;
import tech.itpark.itpark2021.lesson33.dto.CurrencyDto;
import tech.itpark.itpark2021.lesson33.dto.ValutaDto;
import tech.itpark.itpark2021.lesson33.service.cbr.CbrInfoProvider;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class CbrInfoProviderImpl implements CbrInfoProvider {

    private final SpringConfiguration config;
    private final ObjectMapper mapper;
    private static Class<CurrencyDto> currencyClass;
    private static Field[] declaredFields;

    static {
        currencyClass = CurrencyDto.class;
        declaredFields = currencyClass.getDeclaredFields();
    }


    @Override
    @SneakyThrows
    public List<ValutaDto> getCurrencyList() {
        CbrDailyInfoDto cbrInfo = mapper.readValue(getUrl(), CbrDailyInfoDto.class);
        List<ValutaDto> currencyList = new ArrayList<>();
        for (Field modelField : declaredFields) {
            modelField.setAccessible(true);
            ValutaDto currency = (ValutaDto) modelField.get(cbrInfo.getValute());
            currencyList.add(currency);
        }
        return currencyList;
    }

    private URL getUrl() {
        return config.getUrl();
    }

}
