package dev.chafon.jira.restclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Team(
        @JsonProperty("value")
        String name
) {
}
