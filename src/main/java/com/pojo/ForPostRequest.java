package com.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
// в паре @NoArgsConstructor и @JsonIgnoreProperties(ignoreUnknown = true)
// заставляют сериализатор Jackson работать
@NoArgsConstructor // Создаёт конструктор без параметров
@JsonIgnoreProperties(ignoreUnknown = true)

public class ForPostRequest {
    private String name;
    private String job;

    public ForPostRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

}
