package tech.itpark.itpark2021.lesson33.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {

    @JsonProperty("AUD")
    private ValutaDto aud;
    @JsonProperty("AZN")
    private ValutaDto azn;
    @JsonProperty("GBP")
    private ValutaDto gbp;
    @JsonProperty("AMD")
    private ValutaDto amd;
    @JsonProperty("BYN")
    private ValutaDto byn;
    @JsonProperty("BGN")
    private ValutaDto bgn;
    @JsonProperty("BRL")
    private ValutaDto brl;
    @JsonProperty("HUF")
    private ValutaDto huf;
    @JsonProperty("HKD")
    private ValutaDto hkd;
    @JsonProperty("DKK")
    private ValutaDto dkk;
    @JsonProperty("USD")
    private ValutaDto usd;
    @JsonProperty("EUR")
    private ValutaDto eur;
    @JsonProperty("INR")
    private ValutaDto inr;
    @JsonProperty("KZT")
    private ValutaDto kzt;
    @JsonProperty("CAD")
    private ValutaDto cad;
    @JsonProperty("KGS")
    private ValutaDto kgs;
    @JsonProperty("CNY")
    private ValutaDto cny;
    @JsonProperty("MDL")
    private ValutaDto mdl;
    @JsonProperty("NOK")
    private ValutaDto nok;
    @JsonProperty("PLN")
    private ValutaDto pln;
    @JsonProperty("RON")
    private ValutaDto ron;
    @JsonProperty("XDR")
    private ValutaDto xdr;
    @JsonProperty("SGD")
    private ValutaDto sgd;
    @JsonProperty("TJS")
    private ValutaDto tjs;
    @JsonProperty("TRY")
    private ValutaDto turkishLira;
    @JsonProperty("TMT")
    private ValutaDto tmt;
    @JsonProperty("UZS")
    private ValutaDto uzs;
    @JsonProperty("UAH")
    private ValutaDto uah;
    @JsonProperty("CZK")
    private ValutaDto czk;
    @JsonProperty("SEK")
    private ValutaDto sek;
    @JsonProperty("CHF")
    private ValutaDto chf;
    @JsonProperty("ZAR")
    private ValutaDto zar;
    @JsonProperty("KRW")
    private ValutaDto krw;
    @JsonProperty("JPY")
    private ValutaDto jpy;

}
