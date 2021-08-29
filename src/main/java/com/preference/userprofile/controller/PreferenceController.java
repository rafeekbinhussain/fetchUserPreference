package com.preference.userprofile.controller;


import com.preference.userprofile.repository.daomodels.Preference;
import com.preference.userprofile.repository.PreferenceRepository;
import com.preference.userprofile.service.PreferenceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/*
 * Controller to handle user preference request
 *
 * */
@RestController
@Slf4j
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @Autowired
    private PreferenceRepository preferenceRepository;

    @GetMapping("/preferences/{userid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch user marketing preference from BackEnd(DB) based on User ID")
    public Preference registerUserInterest(@PathVariable(required = true) String userid) {
        return preferenceService.fetchUserPreferenceByUserId(userid);
    }


    @GetMapping("/preferences")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch all user marketing preference from BackEnd(DB)")
    public List<Preference> registerUserInterest() {
        List<Preference> preference = preferenceRepository.findAll();

        if (preference.isEmpty()) {
            return Collections.emptyList();
        }
        return preference;
    }
}