package dev.chafon.jira.restclient.dto;

public record Project(
        String id,
        String key,
        String name
) {
}
