package com.calorietracker.services.services;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Intents {

    LOG_CONSUMPTION("log_consumption"),
    LOG_CALORIES("log_calories");

    private final String description;

    Intents(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static Intents getEnum(String value) {
        List<Intents> list = Arrays.asList(Intents.values());
        return list.stream().filter(m -> m.description.equals(value)).findAny().orElseThrow(IllegalArgumentException::new);
    }
}
