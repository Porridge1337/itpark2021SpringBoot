package lesson40.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lesson40.model.Genre;
import lesson40.repository.GenreRepository;
import org.bson.Document;

@ChangeLog
public class DbChangeLog {

    @ChangeSet(order = "001", id = "drop db", author = "Ilya Zhdanov", runAlways = true)
    public void dropDb(MongoDatabase db){
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertNewGenre", author = "Ilya Zhdanov")
    public void insertNewGenre(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("genre");
        Document doc = new Document()
                .append("_id", "test")
                .append("name", "Тест");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertNewGenreAnotherWay", author = "Ilya Zhdanov")
    public void insertTestGenre(GenreRepository repository) {
        repository.save(new Genre("testGenre", "Тестовый жанр"));
    }

}
