package lesson41.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("directory")
public class Directory {

    @Id
    private String regionId;

    @NotEmpty
    private String regionName;

    public String getIdStr() {
        return String.format("dir_%s", regionId);
    }
}
