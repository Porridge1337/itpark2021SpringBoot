package tech.itpark.itpark2021.lesson29.service;

import java.io.File;
import java.util.List;

public interface ZipFiles {

    boolean createZipFile(String filename, String addingFileName, char[] password);

    boolean createZipFiles(String filename, List<File> files, char[] password);

    boolean createZipFileByFolder(String filename, File folder, char[] password);

}
