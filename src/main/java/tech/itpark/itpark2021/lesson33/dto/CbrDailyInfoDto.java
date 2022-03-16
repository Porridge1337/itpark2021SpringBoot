package tech.itpark.itpark2021.lesson33.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CbrDailyInfoDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ssXXX")
    @JsonProperty("Date")
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ssXXX")
    @JsonProperty("PreviousDate")
    private Date previousDate;
    @JsonProperty("PreviousURL")
    private String previousURL;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ssXXX")
    @JsonProperty("Timestamp")
    private Date timestamp;
    @JsonProperty("Valute")
    private CurrencyDto valute;

}
