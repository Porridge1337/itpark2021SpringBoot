package lesson41.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.reactivestreams.client.MongoDatabase;
import lesson41.model.Directory;
import lesson41.repository.DirectoryRepository;

@ChangeLog
public class DbChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "Ilya Zhdanov", runAlways = true)
    public void dropDb(MongoDatabase db){
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertRepublic", author = "Ilya Zhdanov")
    public void insertRepublicOfAdigeya(DirectoryRepository repository) {
        repository.save(new Directory("01", "Республика Адыгея"));
    }

    @ChangeSet(order = "003", id = "insertNewRepublic", author = "Ilya Zhdanov")
    public void insertRepublicOfKomi(DirectoryRepository repository) {
        repository.save(new Directory("11", "Республика Коми"));
    }

}
