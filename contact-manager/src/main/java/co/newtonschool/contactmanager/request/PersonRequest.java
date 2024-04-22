package co.newtonschool.contactmanager.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PersonRequest(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("company") String company,
        @JsonProperty("landline") String landline,
        @JsonProperty("mobile") String mobile,
        @JsonProperty("email") String email
) {

}
