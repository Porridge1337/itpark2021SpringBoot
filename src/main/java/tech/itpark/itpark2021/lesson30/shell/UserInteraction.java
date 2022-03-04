package tech.itpark.itpark2021.lesson30.shell;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import tech.itpark.itpark2021.lesson30.service.TownDirectoryDao;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class UserInteraction {

    private final TownDirectoryDao dao;

    @ShellMethod(value = "Shows all records in town directory", key = {"showAll"})
    public void showAllRecords() {
        log.info("Список всех записей в справочнике {}", dao.getAllRecords());
    }

    @ShellMethod(value = "Show record by city name", key = {"showRecord"})
    public void showRecordByCitiName(@ShellOption({"-n", "--cityName"}) String cityName) {
        if (dao.recordIsExits(cityName)) {
            log.info("Запись в справочнике {}", dao.getRecordByCityName(cityName));
        } else {
            log.warn("Запись отсуствует");
        }
    }

    @ShellMethod(value = "Create new record", key = {"createRecord"})
    public void createRecord(@ShellOption("-n") String cityName,
                             @ShellOption("-c") int cityCode,
                             @ShellOption("-p") long population) {
        dao.createNewRecord(cityName, cityCode, population);
        log.info("Создание новой записи прошло успешно");
    }

    @ShellMethod(value = "Delete record from townd directory", key = {"deleteRecord"})
    public void deleteRecord(@ShellOption("-d") String cityName) {
        if (dao.deleteRecord(cityName)) {
            log.info("Удаление записи с городм {} произошло успшно", cityName);
        } else {
            log.warn("Удаление записи не произошло, отсутсвует запись с городом {}", cityName);
        }
    }
}
