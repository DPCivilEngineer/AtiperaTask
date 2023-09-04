package com.example.Task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class GithubTaskController {

    private final GithubApiClient githubApiClient;

    public GithubTaskController(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;
    }

    @GetMapping("/repositories")
    public ResponseEntity<Object> getUserRepositories(
            @RequestParam String username,
            @RequestParam(name = "Accept", required = false, defaultValue = "application/json") String acceptHeader
    ) {
        try {
            if (acceptHeader.equals("application/xml")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Acceptable");
            } else {
                String repositoriesJson = githubApiClient.getUserRepositories(username);
                return ResponseEntity.ok(repositoriesJson);
            }
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"status\": 404, \"Message\": \"User not found\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/repository/branches")
    public ResponseEntity<Object> getRepositoryBranches(
            @RequestParam String username,
            @RequestParam String repositoryName,
            @RequestParam(name = "Accept", required = false, defaultValue = "application/json") String acceptHeader
    ) {
        try {
            if (acceptHeader.equals("application/xml")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Acceptable");
            } else {
                String branchesJson = githubApiClient.getRepositoryBranches(username, repositoryName);
                return ResponseEntity.ok(branchesJson);
            }
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"status\": 404, \"Message\": \"Repository or user not found\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/repository/lastcommit")
    public ResponseEntity<Object> getRepositoryLastCommit(
            @RequestParam String username,
            @RequestParam String repositoryName,
            @RequestParam(name = "Accept", required = false, defaultValue = "application/json") String acceptHeader
    ) {
        try {
            if (acceptHeader.equals("application/xml")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Acceptable");
            } else {
                String lastCommitJson = githubApiClient.getRepositoryLastCommit(username, repositoryName);
                return ResponseEntity.ok(lastCommitJson);
            }
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"status\": 404, \"Message\": \"Repository or user not found\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}