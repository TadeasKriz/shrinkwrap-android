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
public class Manifest implements XmlNode {
    public static final String DEFAULT_XMLNS_ANDROID = "http://schemas.android.com/apk/res/android";

    private String xmlnsAndroid = DEFAULT_XMLNS_ANDROID;
    private String pack = null;
    private String sharedUserId = null;
    private String sharedUserLabel = null;
    private Integer versionCode = null;
    private String versionName = null;
    private String installLocation = null;

    private Application application = null;
    private Instrumentation instrumentation = null;
    private List<Permission> permissionList = new ArrayList<Permission>();
    private List<PermissionGroup> permissionGroupList = new ArrayList<PermissionGroup>();
    private List<PermissionTree> permissionTreeList = new ArrayList<PermissionTree>();
    private List<UsesConfiguration> usesConfigurationList = new ArrayList<UsesConfiguration>();
    private List<UsesPermission> usesPermissionList = new ArrayList<UsesPermission>();
    private UsesSdk usesSdk = null;

    public String getXmlnsAndroid() {
        return xmlnsAndroid;
    }

    public Manifest setXmlnsAndroid(String xmlnsAndroid) {
        this.xmlnsAndroid = xmlnsAndroid;
        return this;
    }

    public String getPackage() {
        return pack;
    }

    public Manifest setPackage(String pack) {
        this.pack = pack;
        return this;
    }

    public String getSharedUserId() {
        return sharedUserId;
    }

    public Manifest setSharedUserId(String sharedUserId) {
        this.sharedUserId = sharedUserId;
        return this;
    }

    public String getSharedUserLabel() {
        return sharedUserLabel;
    }

    public Manifest setSharedUserLabel(String sharedUserLabel) {
        this.sharedUserLabel = sharedUserLabel;
        return this;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public Manifest setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
        return this;
    }

    public String getVersionName() {
        return versionName;
    }

    public Manifest setVersionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public Manifest setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
        return this;
    }

    public Application getApplication() {
        return application;
    }

    public Manifest setApplication(Application application) {
        this.application = application;
        return this;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public Manifest addInstrumentation(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
        return this;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public Manifest addPermission(Permission permission) {
        permissionList.add(permission);
        return this;
    }

    public List<PermissionGroup> getPermissionGroupList() {
        return permissionGroupList;
    }

    public Manifest addPermissionGroup(PermissionGroup permissionGroup) {
        permissionGroupList.add(permissionGroup);
        return this;
    }

    public List<PermissionTree> getPermissionTreeList() {
        return permissionTreeList;
    }

    public Manifest addPermissionTree(PermissionTree permissionTree) {
        permissionTreeList.add(permissionTree);
        return this;
    }

    public List<UsesConfiguration> getUsesConfigurationList() {
        return usesConfigurationList;
    }

    public Manifest addUsesConfiguration(UsesConfiguration usesConfiguration) {
        usesConfigurationList.add(usesConfiguration);
        return this;
    }

    public List<UsesPermission> getUsesPermissionList() {
        return usesPermissionList;
    }

    public Manifest addUsesPermission(UsesPermission usesPermission) {
        usesPermissionList.add(usesPermission);
        return this;
    }

    public UsesSdk getUsesSdk() {
        return usesSdk;
    }

    public Manifest setUsesSdk(UsesSdk usesSdk) {
        this.usesSdk = usesSdk;
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation

        if (application != null) {
            application.validate();
        }

        if (instrumentation != null) {
            instrumentation.validate();
        }

        for (Permission permission : permissionList) {
            permission.validate();
        }

        for (PermissionGroup permissionGroup : permissionGroupList) {
            permissionGroup.validate();
        }

        for (PermissionTree permissionTree : permissionTreeList) {
            permissionTree.validate();
        }

        for (UsesConfiguration usesConfiguration : usesConfigurationList) {
            usesConfiguration.validate();
        }

        for (UsesPermission usesPermission : usesPermissionList) {
            usesPermission.validate();
        }

        if (usesSdk != null) {
            usesSdk.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<manifest \n");
        if (xmlnsAndroid != null) {
            builder.append(indent).append("\txmlns:android=\"").append(xmlnsAndroid).append("\" \n");
        }
        if (pack != null) {
            builder.append(indent).append("\tpackage=\"").append(pack).append("\" \n");
        }
        if (sharedUserId != null) {
            builder.append(indent).append("\tandroid:sharedUserId=\"").append(sharedUserId).append("\" \n");
        }
        if (sharedUserLabel != null) {
            builder.append(indent).append("\tandroid:sharedUserLabel=\"").append(sharedUserLabel).append("\" \n");
        }
        if (versionCode != null) {
            builder.append(indent).append("\tandroid:versionCode=\"").append(versionCode).append("\" \n");
        }
        if (versionName != null) {
            builder.append(indent).append("\tandroid:versionName=\"").append(versionName).append("\" \n");
        }
        if (installLocation != null) {
            builder.append(indent).append("\tandroid:installLocation=\"").append(installLocation).append("\" \n");
        }

        builder.append(indent).append(">\n");

        if (application != null) {
            builder.append(application.toXmlString(indent + "\t"));
        }

        if (instrumentation != null) {
            builder.append(instrumentation.toXmlString(indent + "\t"));
        }

        for (Permission permission : permissionList) {
            builder.append(permission.toXmlString(indent + "\t"));
        }

        for (PermissionGroup permissionGroup : permissionGroupList) {
            builder.append(permissionGroup.toXmlString(indent + "\t"));
        }

        for (PermissionTree permissionTree : permissionTreeList) {
            builder.append(permissionTree.toXmlString(indent + "\t"));
        }

        for (UsesConfiguration usesConfiguration : usesConfigurationList) {
            builder.append(usesConfiguration.toXmlString(indent + "\t"));
        }

        for (UsesPermission usesPermission : usesPermissionList) {
            builder.append(usesPermission.toXmlString(indent + "\t"));
        }

        if (usesSdk != null) {
            builder.append(usesSdk.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</manifest>");

        return builder.toString();
    }

    public interface InstallLocation {
        public static final String AUTO = "auto";
        public static final String INTERNAL_ONLY = "internalOnly";
        public static final String PREFER_EXTERNAL = "preferExternal";
    }

}
