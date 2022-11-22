package com.johnson.spring.controller;

import com.johnson.spring.model.Holiday;
import com.johnson.spring.model.HolidayType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HolidayController {

    /**
     * El nombre de los parámetros ha de ser igual a como se les pasa por front
     *
     * <li><a th:href="@{/holidays(festival='true', federal='true')}">Holidays</a></li>
     *
     * festival y federal han de respetarse, de modo que cuando se usen en el back
     * o se usa el mismo nombre para el nombre de los parámetros, o se usa el nombre de
     * parámetro que se quiera pero en el atributo value="" tiene que ir el nombre
     * que tiene en front.
     *
     * @param festival
     * @param federalHoliday
     * @param model
     * @return
     */
    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) String festival,
                                  @RequestParam(required = true, value = "federal") String federalHoliday,
                                  Model model) {

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federalHoliday);
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", HolidayType.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", HolidayType.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", HolidayType.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", HolidayType.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", HolidayType.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", HolidayType.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", HolidayType.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", HolidayType.FEDERAL)
        );

        for (HolidayType type: HolidayType.values()) {
            model.addAttribute(type.toString(),
                    (holidays.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}