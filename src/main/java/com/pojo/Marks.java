package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
//@AllArgsConstructor
public class Marks {
    private int russian;
    private int english;

    public Marks(int russian, int english) {
        this.russian = russian;
        this.english = english;
    }

    public Marks()
    {
        super();
    }

}

