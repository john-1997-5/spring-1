package com.johnson.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Holiday {
    private final String day;
    private final String reason;
    private final HolidayType type;
}