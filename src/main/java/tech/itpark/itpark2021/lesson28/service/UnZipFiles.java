package tech.itpark.itpark2021.lesson28.service;

import java.io.File;

public interface UnZipFiles {

    void extractFile(File filenameDestination, char[] password);
}
