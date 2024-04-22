package co.newtonschool.contactmanager.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuccessResponse(
        @JsonProperty("message") String message
) {
}
