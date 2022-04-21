/*
 * Copyright © 2019 Smoke Turner, LLC (github@smoketurner.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.dropwizard.graphql;

import com.apollographql.federation.graphqljava._Entity;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class EntitiesDataFetcher implements DataFetcher<Object> {
  @Override
  public Object get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
    return dataFetchingEnvironment.<List<Map<String, Object>>>getArgument(_Entity.argumentName)
        .stream()
        .map(this::resolveReference)
        .collect(Collectors.toList());
  }

  public abstract Object resolveReference(Map<String, Object> ref);
}
