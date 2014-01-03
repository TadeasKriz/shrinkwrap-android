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
public class PermissionGroup implements XmlNode {

    private String description = null;
    private String icon = null;
    private String label = null;
    private String name = null;

    /**
     * User-readable text that describes the group. The text should be longer and more explanatory than the label. This
     * attribute must be set as a reference to a string resource. Unlike the label attribute, it cannot be a raw string.
     */
    public String getDescription() {
        return description;
    }

    public PermissionGroup setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * An icon representing the permission. This attribute must be set as a reference to a drawable resource containing the
     * image definition.
     */
    public String getIcon() {
        return icon;
    }

    public PermissionGroup setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * A user-readable name for the group. As a convenience, the label can be directly set as a raw string while you're
     * developing the application. However, when the application is ready to be published, it should be set as a reference to a
     * string resource, so that it can be localized like other strings in the user interface.
     */
    public String getLabel() {
        return label;
    }

    public PermissionGroup setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * The name of the group. This is the name that can be assigned to a &lt;permission&gt; element's &lt;permissionGroup&gt;
     * attribute.
     */
    public String getName() {
        return name;
    }

    public PermissionGroup setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void validate() {
        if (name == null) {
            throw new IllegalStateException("Attribute \"name\" mustn't be null!");
        }
    }

    /**
     * @return xml representation of this PermissionGroup.
     * @param indent
     */
    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<permission-group \n");
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (description != null) {
            builder.append(indent).append("\tandroid:description=\"").append(description).append("\" \n");
        }
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
