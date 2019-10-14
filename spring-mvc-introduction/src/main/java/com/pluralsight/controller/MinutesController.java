package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {

    @RequestMapping(value = "/addMinutes")
    /* The @ModelAttribute value corresponds to the object's name that is linked to */
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

        System.out.println("Exercise: " + exercise.getMinutes());

        return "addMinutes";
    }
}
