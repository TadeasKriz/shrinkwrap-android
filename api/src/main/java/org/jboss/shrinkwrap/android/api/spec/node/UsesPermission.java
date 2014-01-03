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
public class UsesPermission implements XmlNode {

    private String name = null;

    /**
     * The name of the permission. It can be a permission defined by the application with the &lt;permission&gt; element, a
     * permission defined by another application, or one of the standard system permissions, such as "android.permission.CAMERA"
     * or "android.permission.READ_CONTACTS". As these examples show, a permission name typically includes the package name as a
     * prefix.
     */
    public String getName() {
        return name;
    }

    public UsesPermission setName(String name) {
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
     * @return xml representation of this UsesPermission
     * @param indent
     */
    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-permission \n");

        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
