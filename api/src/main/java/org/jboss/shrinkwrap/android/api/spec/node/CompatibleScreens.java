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

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class CompatibleScreens implements XmlNode {

    private List<Screen> screenList = new ArrayList<Screen>();

    public List<Screen> getScreenList() {
        return screenList;
    }

    public CompatibleScreens addScreen(Screen screen) {
        this.screenList.add(screen);
        return this;
    }

    @Override
    public void validate() {
        for (Screen screen : screenList) {
            screen.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<compatible-screens>\n");
        for (Screen screen : screenList) {
            builder.append(screen.toXmlString(indent + "\t"));
        }
        builder.append(indent).append("</compatible-screens>\n");

        return builder.toString();
    }

    public static class Screen implements XmlNode {

        private String screenSize = null;
        private String screenDensity = null;

        public String getScreenSize() {
            return screenSize;
        }

        public Screen setScreenSize(String screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public String getScreenDensity() {
            return screenDensity;
        }

        public Screen setScreenDensity(String screenDensity) {
            this.screenDensity = screenDensity;
            return this;
        }

        @Override
        public void validate() {
            if (screenSize == null) {
                throw new IllegalStateException("Attribute \"screenSize\" mustn't be null!");
            }
            if (screenDensity == null) {
                throw new IllegalStateException("Attribute \"screenDensity\" mustn't be null!");
            }
        }

        @Override
        public String toXmlString(String indent) {
            StringBuilder builder = new StringBuilder();

            builder.append(indent).append("<screen \n");
            if (screenSize != null) {
                builder.append(indent).append("\tandroid:screenSize=\"").append(screenSize).append("\" \n");
            }
            if (screenDensity != null) {
                builder.append(indent).append("\tandroid:screenDensity=\"").append(screenDensity).append("\" \n");
            }
            builder.append(indent).append("/>");

            return builder.toString();
        }
    }

    public interface ScreenSize {
        public static final String SMALL = "small";
        public static final String NORMAL = "normal";
        public static final String LARGE = "large";
        public static final String XLARGE = "xlarge";
    }

    public interface ScreenDensity {
        public static final String LDPI = "ldpi";
        public static final String MDPI = "mdpi";
        public static final String HDPI = "hdpi";
        public static final String XHDPI = "xhdpi";
    }

}
