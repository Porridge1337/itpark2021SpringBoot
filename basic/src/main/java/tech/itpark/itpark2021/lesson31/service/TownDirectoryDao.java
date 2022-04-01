package tech.itpark.itpark2021.lesson31.service;


import tech.itpark.itpark2021.lesson31.model.TownDirectory;

import java.util.List;

public interface TownDirectoryDao {

    void createNewRecord(String cityName, int cityCode, long population);

    void updateCityName(String name, long id);

    void updateCityCode(int code, long id);

    void updatePopulation(long population, long id);

    void updateTownDirectoryById(long id, String cityName, int cityCode, long population);

    boolean deleteRecord(String cityName);

    boolean recordIsExits(String cityName);

    List<TownDirectory> getAllRecords();

    TownDirectory getRecordByCityName(String cityName);


}
