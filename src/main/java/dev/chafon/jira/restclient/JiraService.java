package dev.chafon.jira.restclient;

import dev.chafon.jira.restclient.dto.Issue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;

@HttpExchange(url = "/api/2")
public interface JiraService {

    @GetExchange("/issue/{id}")
    Issue getIssueById(@RequestHeader Map<String, String> headers, @PathVariable String id);
}
