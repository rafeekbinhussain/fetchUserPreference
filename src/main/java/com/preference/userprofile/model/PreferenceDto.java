package com.preference.userprofile.model;


import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenceDto {

    @NotBlank(message = "User ID could not be null or Blank.")
    private String userId;

    @ApiModelProperty(example = "true or false", hidden = false)
    private Boolean postPreference;

    @ApiModelProperty(example = "true or false", hidden = false)
    private Boolean emailPreference;

    @ApiModelProperty(example = "true or false", hidden = false)
    private Boolean smsPreference;

}
