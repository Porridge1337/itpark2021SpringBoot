package tech.itpark.itpark2021.lesson31.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.itpark2021.lesson31.model.TownDirectory;
import tech.itpark.itpark2021.lesson31.repository.TownDirectoryRepository;
import tech.itpark.itpark2021.lesson31.service.TownDirectoryDao;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TownDirectoryDaoJpa implements TownDirectoryDao {

    private final TownDirectoryRepository repository;

    @Override
    public List<TownDirectory> getAllRecords() {
        List<TownDirectory> records = new ArrayList<>();
        repository.findAll().forEach(records::add);
        return records;
    }

    @Override
    public TownDirectory getRecordByCityName(String cityName) {
        return repository.findByCityName(cityName);
    }

    @Override
    public boolean recordIsExits(String cityName) {
        return repository.existsByCityName(cityName);
    }

    @Override
    public void createNewRecord(String cityName, int cityCode, long population) {
        repository.save(new TownDirectory(cityName, cityCode, population));
    }

    @Override
    @Transactional
    public void updateCityName(String name, long id) {
        repository.updateCityName(name, id);
    }

    @Override
    @Transactional
    public void updateCityCode(int code, long id) {
        repository.updateCityCode(code, id);
    }

    @Override
    @Transactional
    public void updatePopulation(long population, long id) {
        repository.updatePopulation(population, id);
    }


    @Override
    public boolean deleteRecord(String cityName) {
        if (repository.existsByCityName(cityName)) {
            TownDirectory record = repository.findByCityName(cityName);
            repository.delete(record);
            return true;
        }
        return false;
    }
}
