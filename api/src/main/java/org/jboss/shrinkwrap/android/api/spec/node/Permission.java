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
public class Permission implements XmlNode {

    private String description = null;
    private String icon = null;
    private String label = null;
    private String name = null;
    private String permissionGroup = null;
    private String protectionLevel = null;

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Permission setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Permission setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getPermissionGroup() {
        return permissionGroup;
    }

    public Permission setPermissionGroup(String permissionGroup) {
        this.permissionGroup = permissionGroup;
        return this;
    }

    public String getProtectionLevel() {
        return protectionLevel;
    }

    public Permission setProtectionLevel(String protectionLevel) {
        this.protectionLevel = protectionLevel;
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

        builder.append(indent).append("<permission \n");
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (description != null) {
            builder.append(indent).append("\t android:description=\"").append(description).append("\" \n");
        }
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if (permissionGroup != null) {
            builder.append(indent).append("\tandroid:permissionGroup=\"").append(permissionGroup).append("\" \n");
        }
        if (protectionLevel != null) {
            builder.append(indent).append("\tandroid:protectionLevel=\"").append(protectionLevel).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }

    public interface ProtectionLevel {
        public static final String NORMAL = "normal";
        public static final String DANGEROUS = "dangerous";
        public static final String SIGNATURE = "signature";
        public static final String SIGNATUREORSYSTEM = "signatureOrSystem";
    }
}
