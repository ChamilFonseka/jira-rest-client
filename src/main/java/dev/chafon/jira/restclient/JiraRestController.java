package dev.chafon.jira.restclient;

import dev.chafon.jira.restclient.dto.Issue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/jira")
public class JiraRestController {

    @Value("${jira.api.key}")
    private String jiraToken;

    private final JiraService jiraService;

    public JiraRestController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @GetMapping("/issue/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable String id) {
        var headers = Map.of("Authorization", "Bearer " + jiraToken);
        var issue = jiraService.getIssueById(headers, id);
        return ResponseEntity.ok(issue);
    }
}
