package tech.itpark.itpark2021.lesson28;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.itpark.itpark2021.lesson28.service.UnZipFiles;
import tech.itpark.itpark2021.lesson28.service.ZipFiles;
import tech.itpark.itpark2021.lesson28.util.UsersUtil;

import java.io.File;

@SpringBootApplication
public class SpringBootRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(SpringBootRunner.class, args);
        ZipFiles zipFiles = appContext.getBean(ZipFiles.class);
        zipFiles.createZipFile(UsersUtil.enterFileName(), UsersUtil.enterLocation(), UsersUtil.enterPassword());
        zipFiles.createZipFiles(UsersUtil.enterFileName(), UsersUtil.enterFilesLocation(), UsersUtil.enterPassword());
        zipFiles.createZipFileByFolder(UsersUtil.enterFileName(), new File(UsersUtil.enterLocation()), UsersUtil.enterPassword());
        UnZipFiles unZipFiles = appContext.getBean(UnZipFiles.class);
        unZipFiles.extractFile(new File(UsersUtil.enterLocation()), UsersUtil.enterPassword());
    }
}
