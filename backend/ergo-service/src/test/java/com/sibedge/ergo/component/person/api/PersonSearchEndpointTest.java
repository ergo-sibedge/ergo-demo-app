package com.sibedge.ergo.component.person.api;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.sibedge.ergo.shared.transport.ListData;
import com.sibedge.ergo.shared.transport.PersonData;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Full API tests for person search endpoint
 *
 * @see com.sibedge.ergo.api.PersonSearchEndpoint
 */
@Transactional
@DisplayName("a search person endpoint")
@SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@Sql(scripts = "/assets/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonSearchEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("returns all records when the filter is empty")
    @Sql(scripts = "/assets/person-set-1.sql")
    void testLoadAllPersonsWithEmptyFilter() {
        // given
        var emptyFilter = Collections.<String, String>emptyMap();

        long expectedPersonsFound = 3L;
        HttpStatus expectedStatus = HttpStatus.OK;

        // when
        var response = executePersonSearchRequest(emptyFilter);

        // then
        var foundPersons = response.getBody();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expectedStatus);
        Assertions.assertThat(foundPersons.getTotal()).isEqualTo(expectedPersonsFound);
    }

    @Test
    @DisplayName("returns only male persons")
    @Sql(scripts = "/assets/person-set-1.sql")
    void testLoadMalePersons() {
        // given
        var onlyMaleFilter = Map.ofEntries(
                Map.entry("gender", "MALE")
        );

        long expectedPersonsFound = 2L;
        HttpStatus expectedStatus = HttpStatus.OK;

        // when
        var response = executePersonSearchRequest(onlyMaleFilter);

        // then
        var foundPersons = response.getBody();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expectedStatus);
        Assertions.assertThat(foundPersons.getTotal()).isEqualTo(expectedPersonsFound);
    }

    @Test
    @DisplayName("returns no male persons")
    @Sql(scripts = "/assets/person-set-2.sql")
    void testLoadNoMalePersons() {
        // given
        var onlyMaleFilter = Map.ofEntries(
                Map.entry("gender", "MALE")
        );

        long expectedPersonsFound = 0L;
        HttpStatus expectedStatus = HttpStatus.OK;

        // when
        var response = executePersonSearchRequest(onlyMaleFilter);

        // then
        var foundPersons = response.getBody();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(expectedStatus);
        Assertions.assertThat(foundPersons.getTotal()).isEqualTo(expectedPersonsFound);
    }

    private ResponseEntity<ListData<PersonData>> executePersonSearchRequest(Map<String, String> params) {
        var headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        var uri = UriComponentsBuilder.fromPath("/persons")
                .queryParamIfPresent("gender", Optional.ofNullable(params.get("gender")))
                .build().toUri();
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new ParameterizedTypeReference<>() { }
        );
    }

}