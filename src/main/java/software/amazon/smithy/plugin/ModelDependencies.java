/*
 * Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.smithy.plugin;

import java.util.List;
import software.amazon.smithy.utils.SmithyBuilder;
import software.amazon.smithy.utils.ToSmithyBuilder;

public final class ModelDependencies implements ToSmithyBuilder<ModelDependencies> {
    private final List<String> artifacts;
    private final List<String> repositories;

    private ModelDependencies(Builder builder) {
        artifacts = builder.artifacts;
        repositories = builder.repositories;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SmithyBuilder<ModelDependencies> toBuilder() {
        return builder()
                .artifacts(artifacts)
                .repositories(repositories);
    }

    public List<String> getArtifacts() {
        return artifacts;
    }

    public List<String> getRepositories() {
        return repositories;
    }

    public static final class Builder implements SmithyBuilder<ModelDependencies> {
        private List<String> artifacts;
        private List<String> repositories;

        Builder() {}

        @Override
        public ModelDependencies build() {
            return new ModelDependencies(this);
        }

        public Builder artifacts(List<String> artifacts) {
            this.artifacts = artifacts;
            return this;
        }

        public Builder repositories(List<String> repositories) {
            this.repositories = repositories;
            return this;
        }
    }
}
