/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class UsesFeature implements XmlNode {

    private String name = null;
    private Boolean required = null;
    private Integer glEsVersion = null;

    public String getName() {
        return name;
    }

    public UsesFeature setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getRequired() {
        return required;
    }

    public UsesFeature setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Integer getGlEsVersion() {
        return glEsVersion;
    }

    public UsesFeature setGlEsVersion(Integer glEsVersion) {
        this.glEsVersion = glEsVersion;
        return this;
    }

    @Override
    public void validate() {
        if (name == null) {
            throw new IllegalStateException("Attribute \"name\" mustn't be null!");
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-feature \n");

        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (required != null) {
            builder.append(indent).append("\tandroid:required=\"").append(required).append("\" \n");
        }
        if (glEsVersion != null) {
            builder.append(indent).append("\tandroid:glEsVersion=\"").append(glEsVersion).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
