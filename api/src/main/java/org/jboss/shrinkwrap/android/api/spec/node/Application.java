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
public class Application implements XmlNode {

    private Boolean allowTaskReparenting = null;
    private String backupAgent = null;
    private Boolean debugable = null;
    private String description = null;
    private Boolean enabled = null;
    private Boolean hasCode = null;
    private Boolean hardwareAccelerated = null;
    private String icon = null;
    private Boolean killAfterRestore = null;
    private Boolean largeHeap = null;
    private String label = null;
    private String logo = null;
    private String manageSpaceActivity = null;
    private String name = null;
    private String permission = null;
    private Boolean persistent = null;
    private String process = null;
    private Boolean restoreAnyVersion = null;
    private Boolean supportsRtl = null;
    private String taskAffinity = null;
    private String theme = null;
    private String uiOptions = null;

    private List<Activity> activityList = new ArrayList<Activity>();
    private List<ActivityAlias> activityAliasList = new ArrayList<ActivityAlias>();
    private List<Service> serviceList = new ArrayList<Service>();
    private List<Receiver> receiverList = new ArrayList<Receiver>();
    private List<Provider> providerList = new ArrayList<Provider>();
    private List<UsesLibrary> usesLibraryList = new ArrayList<UsesLibrary>();

    public Boolean getAllowTaskReparenting() {
        return allowTaskReparenting;
    }

    public Application setAllowTaskReparenting(Boolean allowTaskReparenting) {
        this.allowTaskReparenting = allowTaskReparenting;
        return this;
    }

    public String getBackupAgent() {
        return backupAgent;
    }

    public Application setBackupAgent(String backupAgent) {
        this.backupAgent = backupAgent;
        return this;
    }

    public Boolean getDebugable() {
        return debugable;
    }

    public Application setDebugable(Boolean debugable) {
        this.debugable = debugable;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Application setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Application setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getHasCode() {
        return hasCode;
    }

    public Application setHasCode(Boolean hasCode) {
        this.hasCode = hasCode;
        return this;
    }

    public Boolean getHardwareAccelerated() {
        return hardwareAccelerated;
    }

    public Application setHardwareAccelerated(Boolean hardwareAccelerated) {
        this.hardwareAccelerated = hardwareAccelerated;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Application setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Boolean getKillAfterRestore() {
        return killAfterRestore;
    }

    public Application setKillAfterRestore(Boolean killAfterRestore) {
        this.killAfterRestore = killAfterRestore;
        return this;
    }

    public Boolean getLargeHeap() {
        return largeHeap;
    }

    public Application setLargeHeap(Boolean largeHeap) {
        this.largeHeap = largeHeap;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Application setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public Application setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getManageSpaceActivity() {
        return manageSpaceActivity;
    }

    public Application setManageSpaceActivity(String manageSpaceActivity) {
        this.manageSpaceActivity = manageSpaceActivity;
        return this;
    }

    public String getName() {
        return name;
    }

    public Application setName(String name) {
        this.name = name;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public Application setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public Boolean getPersistent() {
        return persistent;
    }

    public Application setPersistent(Boolean persistent) {
        this.persistent = persistent;
        return this;
    }

    public String getProcess() {
        return process;
    }

    public Application setProcess(String process) {
        this.process = process;
        return this;
    }

    public Boolean getRestoreAnyVersion() {
        return restoreAnyVersion;
    }

    public Application setRestoreAnyVersion(Boolean restoreAnyVersion) {
        this.restoreAnyVersion = restoreAnyVersion;
        return this;
    }

    public Boolean getSupportsRtl() {
        return supportsRtl;
    }

    public Application setSupportsRtl(Boolean supportsRtl) {
        this.supportsRtl = supportsRtl;
        return this;
    }

    public String getTaskAffinity() {
        return taskAffinity;
    }

    public Application setTaskAffinity(String taskAffinity) {
        this.taskAffinity = taskAffinity;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public Application setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getUiOptions() {
        return uiOptions;
    }

    public Application setUiOptions(String uiOptions) {
        this.uiOptions = uiOptions;
        return this;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public Application addActivity(Activity activity) {
        activityList.add(activity);
        return this;
    }

    public List<ActivityAlias> getActivityAliasList() {
        return activityAliasList;
    }

    public Application addActivityAlias(ActivityAlias activityAlias) {
        activityAliasList.add(activityAlias);
        return this;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public Application addService(Service service) {
        serviceList.add(service);
        return this;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public Application addReceiver(Receiver receiver) {
        receiverList.add(receiver);
        return this;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public Application addProvider(Provider provider) {
        providerList.add(provider);
        return this;
    }

    public List<UsesLibrary> getUsesLibraryList() {
        return usesLibraryList;
    }

    public Application addUsesLibrary(UsesLibrary usesLibrary) {
        usesLibraryList.add(usesLibrary);
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation!

        for (Activity activity : activityList) {
            activity.validate();
        }

        for (ActivityAlias activityAlias : activityAliasList) {
            activityAlias.validate();
        }

        for (Service service : serviceList) {
            service.validate();
        }

        for (Receiver receiver : receiverList) {
            receiver.validate();
        }

        for (Provider provider : providerList) {
            provider.validate();
        }

        for (UsesLibrary usesLibrary : usesLibraryList) {
            usesLibrary.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<application \n");

        if (allowTaskReparenting != null) {
            builder.append(indent).append("\tandroid:allowTaskReparenting=\"").append(allowTaskReparenting).append("\" \n");
        }
        if (backupAgent != null) {
            builder.append(indent).append("\tandroid:backupAgent=\"").append(backupAgent).append("\" \n");
        }
        if (debugable != null) {
            builder.append(indent).append("\tandroid:debugable=\"").append(debugable).append("\" \n");
        }
        if (description != null) {
            builder.append(indent).append("\tandroid:description=\"").append(description).append("\" \n");
        }
        if (enabled != null) {
            builder.append(indent).append("\tandroid:enabled=\"").append(enabled).append("\" \n");
        }
        if (hasCode != null) {
            builder.append(indent).append("\tandroid:hasCode=\"").append(hasCode).append("\" \n");
        }
        if (hardwareAccelerated != null) {
            builder.append(indent).append("\tandroid:hardwareAccelerated=\"").append(hardwareAccelerated).append("\" \n");
        }
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if (killAfterRestore != null) {
            builder.append(indent).append("\tandroid:killAfterRestore=\"").append(killAfterRestore).append("\" \n");
        }
        if (largeHeap != null) {
            builder.append(indent).append("\tandroid:largeHeap=\"").append(largeHeap).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (logo != null) {
            builder.append(indent).append("\tandroid:logo=\"").append(logo).append("\" \n");
        }
        if (manageSpaceActivity != null) {
            builder.append(indent).append("\tandroid:manageSpaceActivity=\"").append(manageSpaceActivity).append("\" \n");
        }
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (permission != null) {
            builder.append(indent).append("\tandroid:permission=\"").append(permission).append("\" \n");
        }
        if (persistent != null) {
            builder.append(indent).append("\tandroid:persistent=\"").append(persistent).append("\" \n");
        }
        if (process != null) {
            builder.append(indent).append("\tandroid:process=\"").append(process).append("\" \n");
        }
        if (restoreAnyVersion != null) {
            builder.append(indent).append("\tandroid:restoreAnyVersion=\"").append(restoreAnyVersion).append("\" \n");
        }
        if (supportsRtl != null) {
            builder.append(indent).append("\tandroid:supportsRtl=\"").append(supportsRtl).append("\" \n");
        }
        if (taskAffinity != null) {
            builder.append(indent).append("\tandroid:taskAffinity=\"").append(taskAffinity).append("\" \n");
        }
        if (theme != null) {
            builder.append(indent).append("\tandroid:theme=\"").append(theme).append("\" \n");
        }
        if (uiOptions != null) {
            builder.append(indent).append("\tandroid:uiOptions=\"").append(uiOptions).append("\" \n");
        }

        builder.append(indent).append(">\n");

        for (Activity activity : activityList) {
            builder.append(activity.toXmlString(indent + "\t"));
        }

        for (ActivityAlias activityAlias : activityAliasList) {
            builder.append(activityAlias.toXmlString(indent + "\t"));
        }

        for (Service service : serviceList) {
            builder.append(service.toXmlString(indent + "\t"));
        }

        for (Receiver receiver : receiverList) {
            builder.append(receiver.toXmlString(indent + "\t"));
        }

        for (Provider provider : providerList) {
            builder.append(provider.toXmlString(indent + "\t"));
        }

        for (UsesLibrary usesLibrary : usesLibraryList) {
            builder.append(usesLibrary.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</application>\n");

        return builder.toString();
    }
}
