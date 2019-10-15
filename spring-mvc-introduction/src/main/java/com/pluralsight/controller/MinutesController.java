package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;

@Controller
public class MinutesController {

    @Autowired
    private ExerciseService exerciseService;
    
    @RequestMapping(value = "/addMinutes")
    /*
     * The @ModelAttribute value corresponds to the object's name that is linked
     * to
     */
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

        System.out.println("Exercise: " + exercise.getMinutes());
        System.out.println("Activity: " + exercise.getActivity());

        return "addMinutes";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAllActivities() {

        return exerciseService.findAllActivities();
    }
}
