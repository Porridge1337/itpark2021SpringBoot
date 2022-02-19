package tech.itpark.itpark2021.lesson28.service.impl;

import net.lingala.zip4j.ZipFile;
import org.springframework.stereotype.Service;
import tech.itpark.itpark2021.lesson28.service.UnZipFiles;

import java.io.File;
import java.io.IOException;

@Service
public class UnZipFilesImpl implements UnZipFiles {

    private static String PATH_TO_EXTRACT = "./src/main/resources/lesson28/extract/";

    @Override
    public void extractFile(File filenameDestination, char[] password) {
        try (ZipFile zipFile = new ZipFile(filenameDestination, password)) {
            zipFile.extractAll(getFolderToExtract(filenameDestination));
            System.out.println("Содержимое архива разархивировался в " + getFolderToExtract(filenameDestination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFolderToExtract(File file) {
        return PATH_TO_EXTRACT + file.getAbsolutePath().
                substring(file.getAbsolutePath().lastIndexOf("\\") + 1);
    }
}
