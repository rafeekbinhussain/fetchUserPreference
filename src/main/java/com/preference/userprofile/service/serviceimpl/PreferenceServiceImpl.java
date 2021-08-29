package com.preference.userprofile.service.serviceimpl;

import com.preference.userprofile.configreader.FeatureToggle;
import com.preference.userprofile.repository.PreferenceRepository;
import com.preference.userprofile.repository.daomodels.Preference;
import com.preference.userprofile.service.PreferenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private FeatureToggle featureToggle;

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public Preference fetchUserPreferenceByUserId(String userId) {
        Preference preference = Preference.builder().build();
        try {
            Preference preferenceDao = preferenceRepository.findByUserId(userId);

            // if user found will return actual user preferred preferences from DB
            if (Objects.nonNull(preferenceDao)) {
                return preferenceRepository.findByUserId(userId);

                //  default values will return if user not chosen any preference
            } else if ((Boolean.TRUE.equals(featureToggle.getUser().getMarketing().getPreferences()))) {
                return Preference.builder()
                        .userId(userId)
                        .postPreference(Boolean.TRUE)
                        .emailPreference(Boolean.TRUE)
                        .smsPreference(Boolean.TRUE)
                        .build();
            } else {
                return Preference.builder()
                        .userId(userId)
                        .postPreference(Boolean.FALSE)
                        .emailPreference(Boolean.FALSE)
                        .smsPreference(Boolean.FALSE)
                        .build();
            }
        } catch (Exception exception) {
            log.error("Unable to fetch User details due to : {}", exception.getMessage());

        }
        return preference;
    }
}
