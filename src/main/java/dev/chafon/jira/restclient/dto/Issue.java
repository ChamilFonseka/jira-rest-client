package dev.chafon.jira.restclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Issue(
        String id,
        String key,
        Fields fields
) {
    record Fields(
            IssueType issuetype,
            String summary,
            String description,
            Status status,
            Project project,
            RoleInfo reporter,
            RoleInfo assignee,
            @JsonProperty("customfield_11103")
            Team team
    ) {
    }
}


