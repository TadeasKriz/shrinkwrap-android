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
public class MetaData implements XmlNode {

    private String name = null;
    private String resource = null;
    private String value = null;

    public String getName() {
        return name;
    }

    public MetaData setName(String name) {
        this.name = name;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public MetaData setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public String getValue() {
        return value;
    }

    public MetaData setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public void validate() {
        if (name == null) {
            throw new IllegalStateException("Attribute \"name\" must not be null!");
        }
        if (resource == null && value == null) {
            throw new IllegalStateException("Both \"resource\" and \"value\" attributes are null!");
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<meta-data \n");
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (resource != null) {
            builder.append(indent).append("\tandroid:resource=\"").append(resource).append("\" \n");
        }
        if (value != null) {
            builder.append(indent).append("\tandroid:value=\"").append(value).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
