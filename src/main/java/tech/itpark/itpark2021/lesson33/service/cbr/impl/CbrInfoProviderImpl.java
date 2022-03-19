package tech.itpark.itpark2021.lesson33.service.cbr.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import tech.itpark.itpark2021.lesson33.dto.CbrDailyInfoDto;
import tech.itpark.itpark2021.lesson33.dto.CurrencyDto;
import tech.itpark.itpark2021.lesson33.dto.ValutaDto;
import tech.itpark.itpark2021.lesson33.service.cbr.CbrInfoProvider;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class CbrInfoProviderImpl implements CbrInfoProvider {

    private static final String CBR_URL = "https://www.cbr-xml-daily.ru/daily_json.js";
    private final ObjectMapper mapper;

    @Override
    public CbrDailyInfoDto getCbrDailyInfo() throws IOException {
        CbrDailyInfoDto cbrInfo = mapper.readValue(getUrl(), CbrDailyInfoDto.class);
        return cbrInfo;
    }

    @Override
    @SneakyThrows
    public List<ValutaDto> getCurrencyList(CbrDailyInfoDto dailyInfo) {
        List<ValutaDto> currencyList = new ArrayList<>();
        Class<CurrencyDto> currencyClass = CurrencyDto.class;
        Field[] declaredFields = currencyClass.getDeclaredFields();
        for (Field modelField : declaredFields) {
            modelField.setAccessible(true);
            ValutaDto currency = (ValutaDto) modelField.get(dailyInfo.getValute());
            currencyList.add(currency);
        }
        return currencyList;
    }

    private URL getUrl() throws MalformedURLException {
        return new URL(CBR_URL);
    }

}
