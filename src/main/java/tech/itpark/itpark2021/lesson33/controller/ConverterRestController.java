package tech.itpark.itpark2021.lesson33.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson33.dto.CbrDailyInfoDto;
import tech.itpark.itpark2021.lesson33.dto.ValutaDto;
import tech.itpark.itpark2021.lesson33.service.cbr.CbrInfoProvider;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConverterRestController {

    private final CbrInfoProvider provider;

    @SneakyThrows
    @GetMapping("/converter")
    public List<ValutaDto> dailyInfo() {
        CbrDailyInfoDto dailyInfo = provider.getCbrDailyInfo();
        return provider.getCurrencyList(dailyInfo);
    }

}
