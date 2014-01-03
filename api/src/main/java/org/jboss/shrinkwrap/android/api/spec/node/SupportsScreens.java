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
public class SupportsScreens implements XmlNode {

    private Boolean resizeable = null;
    private Boolean smallScreens = null;
    private Boolean normalScreens = null;
    private Boolean largeScreens = null;
    private Boolean xlargeScreens = null;
    private Boolean anyDensity = null;
    private Integer requiresSmallestWidthDp = null;
    private Integer compatibleWidthLimitDp = null;
    private Integer largestWidthLimitDp = null;

    public Boolean getResizeable() {
        return resizeable;
    }

    public SupportsScreens setResizeable(Boolean resizeable) {
        this.resizeable = resizeable;
        return this;
    }

    public Boolean getSmallScreens() {
        return smallScreens;
    }

    public SupportsScreens setSmallScreens(Boolean smallScreens) {
        this.smallScreens = smallScreens;
        return this;
    }

    public Boolean getNormalScreens() {
        return normalScreens;
    }

    public SupportsScreens setNormalScreens(Boolean normalScreens) {
        this.normalScreens = normalScreens;
        return this;
    }

    public Boolean getLargeScreens() {
        return largeScreens;
    }

    public SupportsScreens setLargeScreens(Boolean largeScreens) {
        this.largeScreens = largeScreens;
        return this;
    }

    public Boolean getXlargeScreens() {
        return xlargeScreens;
    }

    public SupportsScreens setXlargeScreens(Boolean xlargeScreens) {
        this.xlargeScreens = xlargeScreens;
        return this;
    }

    public Boolean getAnyDensity() {
        return anyDensity;
    }

    public SupportsScreens setAnyDensity(Boolean anyDensity) {
        this.anyDensity = anyDensity;
        return this;
    }

    public Integer getRequiresSmallestWidthDp() {
        return requiresSmallestWidthDp;
    }

    public SupportsScreens setRequiresSmallestWidthDp(Integer requiresSmallestWidthDp) {
        this.requiresSmallestWidthDp = requiresSmallestWidthDp;
        return this;
    }

    public Integer getCompatibleWidthLimitDp() {
        return compatibleWidthLimitDp;
    }

    public SupportsScreens setCompatibleWidthLimitDp(Integer compatibleWidthLimitDp) {
        this.compatibleWidthLimitDp = compatibleWidthLimitDp;
        return this;
    }

    public Integer getLargestWidthLimitDp() {
        return getLargestWidthLimitDp();
    }

    public SupportsScreens setLargestWidthLimitDp(Integer largestWidthLimitDp) {
        this.largestWidthLimitDp = largestWidthLimitDp;
        return this;
    }

    @Override
    public void validate() {
        if (requiresSmallestWidthDp < 0) {
            throw new IllegalStateException("Attribute \"requiresSmallestWidthDp\" has to be >= 0!");
        }
        if (compatibleWidthLimitDp < 0) {
            throw new IllegalStateException("Attribute \"compatibleWidthLimitDp\" has to be >= 0!");
        }
        if (largestWidthLimitDp < 0) {
            throw new IllegalStateException("Attribute \"largestWidthLimitDp\" has to be >= 0!");
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<supports-screens \n");

        if (resizeable != null) {
            builder.append(indent).append("\tandroid:resizeable=\"").append(resizeable).append("\" \n");
        }
        if (smallScreens != null) {
            builder.append(indent).append("\tandroid:smallScreens=\"").append(smallScreens).append("\" \n");
        }
        if (normalScreens != null) {
            builder.append(indent).append("\tandroid:normalScreens=\"").append(normalScreens).append("\" \n");
        }
        if (largeScreens != null) {
            builder.append(indent).append("\tandroid:largeScreens=\"").append(largeScreens).append("\" \n");
        }
        if (xlargeScreens != null) {
            builder.append(indent).append("\tandroid:xlargescreens=\"").append(xlargeScreens).append("\" \n");
        }
        if (anyDensity != null) {
            builder.append(indent).append("\tandroid:anyDensity=\"").append(anyDensity).append("\" \n");
        }
        if (requiresSmallestWidthDp != null) {
            builder.append(indent)
                .append("\tandroid:requiresSmallestWidthDp=\"")
                .append(requiresSmallestWidthDp)
                .append("\" \n");
        }
        if (compatibleWidthLimitDp != null) {
            builder.append(indent).append("\tandroid:compatibleWidthLimitDp=\"").append(compatibleWidthLimitDp).append("\" \n");
        }
        if (largestWidthLimitDp != null) {
            builder.append(indent).append("\tandroid:largestWidthLimitDp=\"").append(largestWidthLimitDp).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
