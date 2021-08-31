package com.preference.userprofile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preference.userprofile.model.PreferenceDto;
import com.preference.userprofile.repository.PreferenceRepository;
import com.preference.userprofile.repository.daomodels.Preference;
import com.preference.userprofile.service.PreferenceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = PreferenceController.class)
class PreferenceControllerTest {

    private static final String URI = "/preferences";
    private static final String URI_BY_ID = "/preferences/15Rafeek";


    @MockBean
    private PreferenceService preferenceService;

    @MockBean
    private PreferenceRepository preferenceRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private Preference preference;

    private List<Preference> preferenceList = new ArrayList<>();


    @BeforeEach
    void setUp() {

        preference = Preference.builder()
                .userId("15RafeeK")
                .smsPreference(false)
                .postPreference(true)
                .emailPreference(true)
                .build();

        preferenceList.add(preference);

    }

    @Test
    void fetchAllUserTest() throws Exception {

        when(preferenceRepository.findAll()).thenReturn(preferenceList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String preferenceJson = result.getResponse().getContentAsString();
        Assertions.assertThat(preferenceJson).isNotEmpty();
    }

    @Test
    void fetchAllUserByIDTest() throws Exception {

        when(preferenceService.fetchUserPreferenceByUserId(anyString())).thenReturn(preference);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URI_BY_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String preferenceJson = result.getResponse().getContentAsString();
        Assertions.assertThat(preferenceJson).isNotEmpty();
    }

}