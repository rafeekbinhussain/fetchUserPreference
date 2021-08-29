package com.preference.userprofile.repository.DaoModels;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Marketing_Preference")
public class Preference implements Serializable {

    private static final long serialVersionUID = 7937663434897942666L;

    @Id
    @Column(name = "userid")
    private String userId;

    @Column(name = "post")
    private Boolean postPreference;

    @Column(name = "email")
    private Boolean emailPreference;

    @Column(name = "sms")
    private Boolean smsPreference;
}
