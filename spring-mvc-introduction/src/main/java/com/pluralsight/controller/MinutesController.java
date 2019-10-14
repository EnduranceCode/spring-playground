package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {

    @RequestMapping(value = "/addMinutes")
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

        System.out.println("Exercise: " + exercise.getMinutes());

        /*
         * "redirect:" closes the first request and creates a new request
         * "forward:" can be used instead of "redirect:" but i doesn't closes
         * the first request, it just forward the same request
         */
        return "redirect:addMoreMinutes.html";
    }

    @RequestMapping(value = "/addMoreMinutes")
    public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {

        System.out.println("Exercising: " + exercise.getMinutes());

        return "addMinutes";
    }
}
