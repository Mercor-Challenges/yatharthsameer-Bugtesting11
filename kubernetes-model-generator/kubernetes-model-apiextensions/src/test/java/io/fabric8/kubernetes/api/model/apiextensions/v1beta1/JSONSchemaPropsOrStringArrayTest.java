/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

class JSONSchemaPropsOrStringArrayTest {
  @Test
  void itDeserializesAdditionalPropertiesTrue() throws IOException {
    InputStream resourceAsStream = getClass().getResourceAsStream("/dependencies_array.json");
    JSONSchemaProps props = new ObjectMapper().readValue(resourceAsStream, JSONSchemaProps.class);

    Assertions.assertEquals(props, new JSONSchemaPropsBuilder()
        .withType("object")
        .addToDependencies(
            "foo",
            new JSONSchemaPropsOrStringArrayBuilder()
                .withProperty("a", "b")
                .build())
        .build());
  }

  @Test
  void itSerializesAdditionalPropertiesTrue() throws JsonProcessingException {
    String expectedJson = new BufferedReader(
        new InputStreamReader(getClass().getResourceAsStream("/dependencies_array.json"), StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));

    String outputJson = new ObjectMapper().writeValueAsString(new JSONSchemaPropsBuilder()
        .withType("object")
        .addToDependencies(
            "foo",
            new JSONSchemaPropsOrStringArrayBuilder()
                .withProperty("a", "b")
                .build())
        .build());

    Assertions.assertEquals(expectedJson, outputJson);
  }

  @Test
  void itDeserializesAdditionalPropertiesTyped() throws IOException {
    InputStream resourceAsStream = getClass().getResourceAsStream("/dependencies_typed.json");
    JSONSchemaProps props = new ObjectMapper().readValue(resourceAsStream, JSONSchemaProps.class);

    Assertions.assertEquals(props, new JSONSchemaPropsBuilder()
        .withType("object")
        .addToDependencies(
            "foo",
            new JSONSchemaPropsOrStringArrayBuilder()
                .withNewSchema()
                .withType("object")
                .endSchema()
                .build())
        .build());
  }

  @Test
  void itSerializesAdditionalPropertiesTyped() throws JsonProcessingException {
    String expectedJson = new BufferedReader(
        new InputStreamReader(getClass().getResourceAsStream("/dependencies_typed.json"), StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));

    String outputJson = new ObjectMapper().writeValueAsString(new JSONSchemaPropsBuilder()
        .withType("object")
        .addToDependencies(
            "foo",
            new JSONSchemaPropsOrStringArrayBuilder()
                .withNewSchema()
                .withType("object")
                .endSchema()
                .build())
        .build());

    Assertions.assertEquals(expectedJson, outputJson);
  }
}
