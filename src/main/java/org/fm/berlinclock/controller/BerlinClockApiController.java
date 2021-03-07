package org.fm.berlinclock.controller;

import org.fm.berlinclock.model.BerlinClockModel;
import org.fm.berlinclock.service.ReproduceOfBerlinClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class BerlinClockApiController {

    @Autowired
    private ReproduceOfBerlinClockService reproduceOfBerlinClockService;

    @GetMapping("/berlinClock")
    public BerlinClockModel getBerlinTimeRepresentation(@RequestParam(name = "time",required = false) String time) throws ParseException {
        Calendar instance = Calendar.getInstance();
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.forLanguageTag("tr"));
            instance.setTime(sdf.parse(time));
        }
        return reproduceOfBerlinClockService.getBerlinRepresentation(instance);
    }

}
