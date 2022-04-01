package tech.itpark.itpark2021.lesson29.service;

import java.io.File;

public interface UnzipFiles {

    boolean extractFile(File filenameDestination, char[] password);
}
