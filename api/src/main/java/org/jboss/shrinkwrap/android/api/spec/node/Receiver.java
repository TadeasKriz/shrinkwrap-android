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
public class Receiver implements XmlNode {

    private Boolean enabled = null;
    private Boolean exported = null;
    private String icon = null;
    private String label = null;
    private String name = null;
    private String permission = null;
    private String process = null;

    private List<IntentFilter> intentFilterList = new ArrayList<IntentFilter>();
    private List<MetaData> metaDataList = new ArrayList<MetaData>();

    public Boolean getEnabled() {
        return enabled;
    }

    public Receiver setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getExported() {
        return exported;
    }

    public Receiver setExported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Receiver setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Receiver setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getName() {
        return name;
    }

    public Receiver setName(String name) {
        this.name = name;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public Receiver setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public String getProcess() {
        return process;
    }

    public Receiver setProcess(String process) {
        this.process = process;
        return this;
    }

    public List<IntentFilter> getIntentFilterList() {
        return intentFilterList;
    }

    public Receiver addIntentFilter(IntentFilter intentFilter) {
        intentFilterList.add(intentFilter);
        return this;
    }

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public Receiver addMetaData(MetaData metaData) {
        metaDataList.add(metaData);
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation

        for (IntentFilter intentFilter : intentFilterList) {
            intentFilter.validate();
        }

        for (MetaData metaData : metaDataList) {
            metaData.validate();
        }

    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<receiver \n");
        if (enabled != null) {
            builder.append(indent).append("\tandroid:enabled=\"").append(enabled).append("\" \n");
        }
        if (exported != null) {
            builder.append(indent).append("\tandroid:exported=\"").append(exported).append("\" \n");
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
        if (permission != null) {
            builder.append(indent).append("\tandroid:permission=\"").append(permission).append("\" \n");
        }
        if (process != null) {
            builder.append(indent).append("\tandroid:process=\"").append(process).append("\" \n");
        }
        builder.append(indent).append(">\n");

        for (IntentFilter intentFilter : intentFilterList) {
            builder.append(intentFilter.toXmlString(indent + "\t"));
        }

        for (MetaData metaData : metaDataList) {
            builder.append(metaData.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</receiver>\n");

        return builder.toString();
    }
}
