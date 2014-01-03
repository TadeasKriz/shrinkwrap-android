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
public class UsesSdk implements XmlNode {

    private Integer minSdkversion = null;
    private Integer targetSdkVersion = null;
    private Integer maxSdkVersion = null;

    public int getMinSdkVersion() {
        return minSdkversion;
    }

    public UsesSdk setMinSdkVersion(Integer minSdkVersion) {
        this.minSdkversion = minSdkVersion;
        return this;
    }

    public Integer getTargetSdkVersion() {
        return targetSdkVersion;
    }

    public UsesSdk setTargetSdkVersion(Integer targetSdkVersion) {
        this.targetSdkVersion = targetSdkVersion;
        return this;
    }

    public Integer getMaxSdkVersion() {
        return maxSdkVersion;
    }

    public UsesSdk setMaxSdkVersion(Integer maxSdkVersion) {
        this.maxSdkVersion = maxSdkVersion;
        return this;
    }

    @Override
    public void validate() {
        if (minSdkversion != null && !(minSdkversion > 0)) {
            throw new IllegalStateException("minSdkVersion is not greater then 0");
        }

        if (maxSdkVersion != null && !(maxSdkVersion > 0)) {
            throw new IllegalStateException("maxSdkVersion is not greater then 0");
        }

        if (targetSdkVersion != null && !(targetSdkVersion > 0)) {
            throw new IllegalStateException("targetSdkVersion is not greater then 0");
        }

        if (minSdkversion != null && maxSdkVersion != null) {
            if (minSdkversion > maxSdkVersion) {
                throw new IllegalStateException("minSdkVersion is higher then maxSdkVersion");
            }
        }

        if (targetSdkVersion != null) {
            if (minSdkversion != null && minSdkversion > targetSdkVersion) {
                throw new IllegalStateException("minSdkVersion is higher then targetSdkVersion");
            }
            if (maxSdkVersion != null && maxSdkVersion < targetSdkVersion) {
                throw new IllegalStateException("maxSdkVersion is lower then targetSdkVersion");
            }
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-sdk \n");

        if (minSdkversion != null) {
            builder.append(indent).append("\tandroid:minSdkVersion=\"").append(minSdkversion).append("\" \n");
        }
        if (targetSdkVersion != null) {
            builder.append(indent).append("\tandroid:targetSdkVersion=\"").append(targetSdkVersion).append("\" \n");
        }
        if (maxSdkVersion != null) {
            builder.append(indent).append("\tandroid:maxSdkVersion=\"").append(maxSdkVersion).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
