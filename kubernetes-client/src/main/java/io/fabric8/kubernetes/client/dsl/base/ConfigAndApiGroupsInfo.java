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
package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.client.Config;

/**
 */
public class ConfigAndApiGroupsInfo {
  private final Config config;
  private final String apiGroupName;
  private final String apiGroupVersion;

  public ConfigAndApiGroupsInfo(Config config, String apiGroupName, String apiGroupVersion) {
    this.config = config;
    this.apiGroupName = apiGroupName;
    this.apiGroupVersion = apiGroupVersion;
  }

  public Config getConfig() {
    return config;
  }

  public String getApiGroupName() {
    return apiGroupName;
  }

  public String getApiGroupVersion() {
    return apiGroupVersion;
  }
}
