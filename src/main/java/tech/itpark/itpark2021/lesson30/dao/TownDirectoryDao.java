package tech.itpark.itpark2021.lesson30.dao;

import tech.itpark.itpark2021.lesson30.model.TownDirectory;

import java.util.List;

public interface TownDirectoryDao {

    void createNewRecord(String cityName, int cityCode, long population);

    boolean deleteRecord(String cityName);

    boolean recordIsExits(String cityName);

    List<TownDirectory> getAllRecords();

    TownDirectory getRecordByCityName(String cityName);


}
