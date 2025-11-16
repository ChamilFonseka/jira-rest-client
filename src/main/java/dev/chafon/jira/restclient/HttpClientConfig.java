package dev.chafon.jira.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration(proxyBeanMethods = false)
@ImportHttpServices(group = "jira", types = {JiraService.class})
public class HttpClientConfig {

    @Value("${jira.base.url}")
    private String jiraBaseUrl;

    @Bean
    public RestClientHttpServiceGroupConfigurer groupConfigurer() {
        return groups -> {
            groups.filterByName("jira")
                    .forEachClient((group, clientBuilder)
                            -> clientBuilder.baseUrl(jiraBaseUrl));

        };
    }
}
