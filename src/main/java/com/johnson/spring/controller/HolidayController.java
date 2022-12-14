package com.johnson.spring.controller;

import com.johnson.spring.model.Holiday;
import com.johnson.spring.model.HolidayType;
import com.johnson.spring.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        boolean festival = display.equals("all") || display.equals("festival");
        boolean federal = display.equals("all") || display.equals("federal");

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

        List<Holiday> holidays = holidayService.getHolidays(display.toUpperCase());

        for (var type : Holiday.Type.values()) {
            model.addAttribute(type.toString(),
                    (holidays.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}