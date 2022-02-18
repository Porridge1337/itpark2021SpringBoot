package tech.itpark.itpark2021.lesson28.service;

import java.io.File;
import java.util.List;

public interface ZipFiles {

    void createZipFile(String filename, String addingFileName, char[] password);

    void createZipFiles(String filename, List<File> files, char[] password);

    void createZipFileByFolder(String filename, File folder, char[] password);

}
