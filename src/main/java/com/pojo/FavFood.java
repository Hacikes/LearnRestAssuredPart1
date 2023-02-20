package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
// Класс для любимых блюд
public class FavFood {
    private String breakfast;
    private String lunch;
    private List<String> dinner;

    public List<String> getDinner() {
        return dinner;
    }
    // Jackson преобразует объект в поток байт и потом в JSON
    public void setDinner(List<String> dinner) {
        this.dinner = dinner;
    }
    public String getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    //Конструктор
    public FavFood(String breakfast, String lunch, List<String> dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }
    public FavFood()
    {
        super();
    }
}