package tech.itpark.itpark2021.lesson33.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValutaDto {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("NumCode")
    private int numCode;
    @JsonProperty("CharCode")
    private String characterCode;
    @JsonProperty("Nominal")
    private BigInteger nominal;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private BigDecimal value;
    @JsonProperty("Previous")
    private BigDecimal previous;

    @Override
    public String toString() {
        return "Валюта с тикером " + characterCode + '\n' +
                "номиналом = " + nominal + " " + name + " " + '\n' +
                "имеет ценность = " + value + '\n';
    }
}
