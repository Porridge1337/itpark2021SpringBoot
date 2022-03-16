package tech.itpark.itpark2021.lesson33.service.cbr;

import tech.itpark.itpark2021.lesson33.dto.CbrDailyInfoDto;
import tech.itpark.itpark2021.lesson33.dto.ValutaDto;

import java.io.IOException;
import java.util.List;

public interface CbrInfoProvider {
    CbrDailyInfoDto getCbrDailyInfo() throws IOException;

    List<ValutaDto> getCurrencyList(CbrDailyInfoDto dailyInfo);
}
