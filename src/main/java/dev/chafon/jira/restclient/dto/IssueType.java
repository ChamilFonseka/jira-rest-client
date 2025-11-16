package dev.chafon.jira.restclient.dto;

public record IssueType(
        String name,
        String description,
        boolean subtask
) {
}
