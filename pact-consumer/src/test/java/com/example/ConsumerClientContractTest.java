package com.example;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ConsumerClientContractTest {

    @Rule
    public PactProviderRuleMk2 rule = new PactProviderRuleMk2("Pact_Provider", this);

    @Pact(provider = "Pact_Provider", consumer = "Pact_Consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder.given("")
                .uponReceiving("a request for Pact")
                .path("/pactDemo")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("[{\"value\":42}, {\"value\":100}]").toPact();
    }

    @Test
    @PactVerification("Pact_Provider")
    public void runTest() {
        assertEquals(new ConsumerClient(rule.getUrl()).pactDemo(), Arrays.asList(new pactDemo(42), new pactDemo(100)));
    }
}
