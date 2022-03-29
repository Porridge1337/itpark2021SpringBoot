package tech.itpark.itpark2021.lesson35.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "region_directory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory {

    @Id
    @Column(name = "region_id")
    @NotEmpty
    private Long regionId;

    @Column(name = "region_name")
    @NotEmpty
    private String regionName;

}
