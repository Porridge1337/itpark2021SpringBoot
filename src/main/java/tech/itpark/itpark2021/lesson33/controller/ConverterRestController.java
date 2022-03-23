package tech.itpark.itpark2021.lesson33.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson33.dto.CbrDailyInfoDto;
import tech.itpark.itpark2021.lesson33.dto.ValutaDto;
import tech.itpark.itpark2021.lesson33.service.cbr.CbrInfoProvider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConverterRestController {

    private final CbrInfoProvider provider;

    @SneakyThrows
    @GetMapping("/converter")
    public List<ValutaDto> dailyInfo() {
        return provider.getCurrencyList();
    }

    @PostMapping("/convert")
    public BigDecimal convert(BigDecimal amount,
                              BigDecimal value) {
        BigDecimal result = amount.multiply(value).setScale(4, RoundingMode.CEILING);
        return result;
    }

    @PostMapping("/reverseConvert")
    public BigDecimal reverseConvert(BigDecimal amount,
                                     BigDecimal value) {
        BigDecimal result = amount.divide(value, 4, RoundingMode.CEILING);
        return result;
    }

}
