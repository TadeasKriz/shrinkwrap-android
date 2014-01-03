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
public class Provider implements XmlNode {

    private List<String> authorities = new ArrayList<String>();
    private Boolean enabled = null;
    private Boolean exported = null;
    private Boolean grantUriPermissions = null;
    private String iconResource = null;
    private Integer initOrder = null;
    private String label = null;
    private Boolean multiprocess = null;
    private String name = null;
    private String permission = null;
    private String process = null;
    private String readPermission = null;
    private Boolean syncable = null;
    private String writePermission = null;

    private List<MetaData> metaDataList = new ArrayList<MetaData>();
    private List<GrantUriPermission> grantUriPermissionList = new ArrayList<GrantUriPermission>();
    private List<PathPermission> pathPermissionList = new ArrayList<PathPermission>();

    public List<String> getAuthorities() {
        return authorities;
    }

    public Provider addAuthority(String authority) {
        authorities.add(authority);
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Provider setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getExported() {
        return exported;
    }

    public Provider setExported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public Boolean getGrantUriPermissions() {
        return grantUriPermissions;
    }

    public Provider setGrantUriPermissions(Boolean grantUriPermissions) {
        this.grantUriPermissions = grantUriPermissions;
        return this;
    }

    public String getIconResource() {
        return iconResource;
    }

    public Provider setIconResource(String iconResource) {
        this.iconResource = iconResource;
        return this;
    }

    public Integer getInitOrder() {
        return initOrder;
    }

    public Provider setInitOrder(Integer initOrder) {
        this.initOrder = initOrder;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Provider setLabel(String label) {
        this.label = label;
        return this;
    }

    public Boolean getMultiprocess() {
        return multiprocess;
    }

    public Provider setMultiprocess(Boolean multiprocess) {
        this.multiprocess = multiprocess;
        return this;
    }

    public String getName() {
        return name;
    }

    public Provider setName(String name) {
        this.name = name;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public Provider setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public String getProcess() {
        return process;
    }

    public Provider setProcess(String process) {
        this.process = process;
        return this;
    }

    public String getReadPermission() {
        return readPermission;
    }

    public Provider setReadPermission(String readPermission) {
        this.readPermission = readPermission;
        return this;
    }

    public Boolean getSyncable() {
        return syncable;
    }

    public Provider setSyncable(Boolean syncable) {
        this.syncable = syncable;
        return this;
    }

    public String getWritePermission() {
        return writePermission;
    }

    public Provider setWritePermission(String writePermission) {
        this.writePermission = writePermission;
        return this;
    }

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public Provider addMetaData(MetaData metaData) {
        metaDataList.add(metaData);
        return this;
    }

    public List<GrantUriPermission> getGrantUriPermissionList() {
        return grantUriPermissionList;
    }

    public Provider addGrantUriPermission(GrantUriPermission grantUriPermission) {
        grantUriPermissionList.add(grantUriPermission);
        return this;
    }

    public List<PathPermission> getPathPermissionList() {
        return pathPermissionList;
    }

    public Provider addPathPermissionList(PathPermission pathPermission) {
        pathPermissionList.add(pathPermission);
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation

        for (MetaData metaData : metaDataList) {
            metaData.validate();
        }

        for (GrantUriPermission grantUriPermission : grantUriPermissionList) {
            grantUriPermission.validate();
        }

        for (PathPermission pathPermission : pathPermissionList) {
            pathPermission.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<provider \n");
        if (authorities.size() > 0) {
            builder.append(indent).append("\tandroid:authorities=\"");
            int i = 0;
            for (String authority : authorities) {
                if (i > 0) {
                    builder.append(",");
                }
                builder.append(authority);
                i++;
            }
            builder.append("\" \n");
        }
        if (enabled != null) {
            builder.append(indent).append("\tandroid:enabled=\"").append(enabled).append("\" \n");
        }
        if (exported != null) {
            builder.append(indent).append("\tandroid:exported=\"").append(exported).append("\" \n");
        }
        if (grantUriPermissions != null) {
            builder.append(indent).append("\tandroid:grantUriPermissions=\"").append(grantUriPermissions).append("\" \n");
        }
        if (iconResource != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(iconResource).append("\" \n");
        }
        if (initOrder != null) {
            builder.append(indent).append("\tandroid:initOrder=\"").append(initOrder).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (multiprocess != null) {
            builder.append(indent).append("\tandroid:multiprocess=\"").append(multiprocess).append("\" \n");
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
        if (readPermission != null) {
            builder.append(indent).append("\tandroid:readPermission=\"").append(readPermission).append("\" \n");
        }
        if (syncable != null) {
            builder.append(indent).append("\tandroid:syncable=\"").append(syncable).append("\" \n");
        }
        if (writePermission != null) {
            builder.append(indent).append("\tandroid:writePermission=\"").append(writePermission).append("\" \n");
        }
        builder.append(indent).append(">\n");

        for (MetaData metaData : metaDataList) {
            builder.append(metaData.toXmlString(indent + "\t"));
        }

        for (GrantUriPermission grantUriPermission : grantUriPermissionList) {
            builder.append(grantUriPermission.toXmlString(indent + "\t"));
        }

        for (PathPermission pathPermission : pathPermissionList) {
            builder.append(pathPermission.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</provider>\n");

        return builder.toString();
    }
}
