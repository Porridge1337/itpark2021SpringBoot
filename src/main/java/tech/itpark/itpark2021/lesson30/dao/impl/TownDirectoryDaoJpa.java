package tech.itpark.itpark2021.lesson30.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.itpark.itpark2021.lesson30.dao.TownDirectoryDao;
import tech.itpark.itpark2021.lesson30.model.TownDirectory;
import tech.itpark.itpark2021.lesson30.repository.TownDirectoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
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
    public boolean deleteRecord(String cityName) {
        if (repository.existsByCityName(cityName)) {
            TownDirectory record = repository.findByCityName(cityName);
            repository.delete(record);
            return true;
        }
        return false;
    }
}
