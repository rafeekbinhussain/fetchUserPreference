package com.preference.userprofile.repository;

import com.preference.userprofile.repository.DaoModels.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, UUID> {

    Preference findByUserId(String userId);
}
