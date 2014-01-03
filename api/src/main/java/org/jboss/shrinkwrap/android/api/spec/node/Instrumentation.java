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
public class Instrumentation implements XmlNode {

    private Boolean functionalTest = null;
    private Boolean handleProfiling = null;
    private String icon = null;
    private String label = null;
    private String name = null;
    private String targetPackage = null;

    public Boolean getFunctionalTest() {
        return functionalTest;
    }

    public Instrumentation setFunctionaltest(Boolean functionaltest) {
        this.functionalTest = functionaltest;
        return this;
    }

    public Boolean getHandleProfiling() {
        return handleProfiling;
    }

    public Instrumentation setHandleProfiling(Boolean handleProfiling) {
        this.handleProfiling = handleProfiling;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Instrumentation setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Instrumentation setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getName() {
        return name;
    }

    public Instrumentation setName(String name) {
        this.name = name;
        return this;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public Instrumentation setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
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

        builder.append(indent).append("<instrumentation \n");
        if (functionalTest != null) {
            builder.append(indent).append("\tandroid:functionalTest=\"").append(functionalTest).append("\" \n");
        }
        if (handleProfiling != null) {
            builder.append(indent).append("\tandroid:handleProfiling=\"").append(handleProfiling).append("\" \n");
        }
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (targetPackage != null) {
            builder.append(indent).append("\tandroid:targetPackage=\"").append(targetPackage).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
