package tech.itpark.itpark2021.lesson33.service.cbr;

import tech.itpark.itpark2021.lesson33.dto.ValutaDto;

import java.util.List;

public interface CbrInfoProvider {

    List<ValutaDto> getCurrencyList();
}
