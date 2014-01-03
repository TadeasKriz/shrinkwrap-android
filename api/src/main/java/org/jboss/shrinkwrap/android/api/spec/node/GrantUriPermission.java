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
public class GrantUriPermission implements XmlNode {

    private String path = null;
    private String pathPattern = null;
    private String pathPrefix = null;

    public String getPath() {
        return path;
    }

    public GrantUriPermission setPath(String path) {
        this.path = path;
        return this;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public GrantUriPermission setPathPattern(String pathPattern) {
        this.pathPattern = pathPattern;
        return this;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public GrantUriPermission setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<grant-uri-permission \n");

        if (path != null) {
            builder.append(indent).append("\tandroid:path=\"").append(path).append("\" \n");
        }
        if (pathPattern != null) {
            builder.append(indent).append("\tandroid:pathPattern=\"").append(pathPattern).append("\" \n");
        }
        if (pathPrefix != null) {
            builder.append(indent).append("\tandroid:pathPrefix=\"").append(pathPrefix).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
