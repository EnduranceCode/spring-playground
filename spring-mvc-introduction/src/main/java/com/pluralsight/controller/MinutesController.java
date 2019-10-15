package com.pluralsight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {

    @RequestMapping(value = "/addMinutes")
    /*
     * The @ModelAttribute value corresponds to the object's name that is linked
     * to
     */
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

        System.out.println("Exercise: " + exercise.getMinutes());

        return "addMinutes";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAllActivities() {

        List<Activity> activities = new ArrayList<>();

        Activity swim = new Activity();
        swim.setDescription("Swim");
        activities.add(swim);

        Activity bike = new Activity();
        bike.setDescription("Bike");
        activities.add(bike);

        Activity run = new Activity();
        run.setDescription("Run");
        activities.add(run);

        return activities;
    }
}
