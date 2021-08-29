package com.preference.userprofile.service;


import com.preference.userprofile.repository.DaoModels.Preference;
import org.springframework.stereotype.Service;

@Service
public interface PreferenceService {

    Preference fetchUserPreferenceByUserId(String userId);
}
