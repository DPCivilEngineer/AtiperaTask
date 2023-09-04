package com.example.Task;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubApiClient {

    private final RestTemplate restTemplate;
    private final String githubApiUrl = "https://api.github.com";

    public GithubApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public String getUserRepositories(String username) {
        String apiUrl = githubApiUrl + "/users/" + username + "/repos";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String getRepositoryBranches(String username, String repositoryName) {
        String apiUrl = githubApiUrl + "/repos/" + username + "/" + repositoryName + "/branches";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String getRepositoryLastCommit(String username, String repositoryName) {
        String apiUrl = githubApiUrl + "/repos/" + username + "/" + repositoryName + "/commits";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}