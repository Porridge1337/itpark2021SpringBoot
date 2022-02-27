package tech.itpark.itpark2021.lesson30.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "db", name = "town_directory")
@NoArgsConstructor
@Data
public class TownDirectory {

    public TownDirectory(String cityName, int cityCode, long population) {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "city_name", nullable = false)
    private String cityName;
    @Column(name = "city_code", nullable = false)
    private int cityCode;
    @Column(name = "population", nullable = false)
    private long population;

    @Override
    public String toString() {
        return "TownDirectory{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityCode=" + cityCode +
                ", population=" + population +
                '}' + "\n";
    }
}
