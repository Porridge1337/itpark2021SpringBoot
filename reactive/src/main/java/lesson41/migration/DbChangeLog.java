package lesson41.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lesson41.model.Directory;
import lesson41.repository.DirectoryRepository;

@ChangeLog
public class DbChangeLog {

    @ChangeSet(order = "001", id = "insertNewRepublic", author = "Ilya Zhdanov")
    public void insertRepublicOfAdigeya(DirectoryRepository repository) {
        repository.save(new Directory("01", "Республика Адыгея"));
    }

}
