package tech.itpark.itpark2021.lesson29.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import tech.itpark.itpark2021.lesson29.service.UnzipFiles;
import tech.itpark.itpark2021.lesson29.service.ZipFiles;

import java.io.File;
import java.util.List;

@Slf4j
@ShellComponent
public class UserInteraction {

    private final ZipFiles zipFiles;
    private final UnzipFiles unzipFiles;

    @Autowired()
    public UserInteraction(ZipFiles zipFiles, UnzipFiles unzipFiles) {
        this.zipFiles = zipFiles;
        this.unzipFiles = unzipFiles;
    }

    @ShellMethod(value = "Archives one file", key = {"zipFile"})
    public void creatingZipFileController(@ShellOption({"-f", "--filename"}) String filename,
                                          @ShellOption({"-l", "--location"}) String location,
                                          @ShellOption({"-p", "--password"}) String password) {
        boolean result = zipFiles.createZipFile(filename, location, password.toCharArray());
        if (!result) {
            log.error("Ошибка при указании параметров для создания zip архива");
        } else {
            log.info("Архивация файла прошла успешно");
        }
    }

    @ShellMethod(value = "Archives some files", key = "zipFiles")
    public void creatingZipFilesController(@ShellOption({"-f", "--filename"}) String fileName,
                                           @ShellOption({"-l", "--location"}) List<File> list,
                                           @ShellOption({"-p", "--password"}) String password) {
        boolean result = zipFiles.createZipFiles(fileName, list, password.toCharArray());
        if (!result) {
            log.error("Ошибка при указании параметров для создания zip архива");
        } else {
            log.info("Архивация файлов прошла успешно");
        }
    }

    @ShellMethod(value = "Archive folder", key = "zipFolder")
    public void creatingZipFolderController(@ShellOption({"-f", "--filename"}) String fileName,
                                            @ShellOption({"-l", "--location"}) File folder,
                                            @ShellOption({"-p", "--password"}) String password) {
        boolean result = zipFiles.createZipFileByFolder(fileName, folder, password.toCharArray());
        if (!result) {
            log.error("Ошибка при указании параметров для создания zip архива");
        } else {
            log.info("Архивация папки прошла успешно");
        }
    }

    @ShellMethod(value = "Unzip folder", key = "unzip")
    public void unZipFileController(@ShellOption({"-l", "--location"}) File filenameDestination,
                                    @ShellOption({"-p", "--password"}) String password) {
        boolean result = unzipFiles.extractFile(filenameDestination, password.toCharArray());
        if (!result) {
            log.error("Ошибка при указании параметров разархивации");
        } else {
            log.info("Разархивация прошла успешно");
        }
    }
}
