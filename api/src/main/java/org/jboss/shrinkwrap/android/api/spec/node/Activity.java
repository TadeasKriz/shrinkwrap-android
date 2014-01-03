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
public class Activity implements XmlNode {

    private Boolean allowTaskReparenting = null;
    private Boolean alwaysRetainTaskState = null;
    private Boolean clearTaskOnLaunch = null;
    private List<String> configChanges = new ArrayList<String>();
    private Boolean enabled = null;
    private Boolean excludeFromRecents = null;
    private Boolean exported = null;
    private Boolean finishOnTaskLaunch = null;
    private Boolean hardwareAccelerated = null;
    private String icon = null;
    private String label = null;
    private String launchMode = null;
    private Boolean multiprocess = null;
    private String name = null;
    private Boolean noHistory = null;
    private String parentActivityName = null;
    private String permission = null;
    private String process = null;
    private String screenOrientation = null;
    private Boolean stateNotNeeded = null;
    private String taskAffinity = null;
    private String theme = null;
    private String uiOptions = null;
    private List<String> windowSoftInputMode = new ArrayList<String>();

    private List<IntentFilter> intentFilterList = new ArrayList<IntentFilter>();
    private List<MetaData> metaDataList = new ArrayList<MetaData>();

    public Boolean getAllowTaskReparenting() {
        return allowTaskReparenting;
    }

    public Activity setAllowTaskReparenting(Boolean allowTaskReparenting) {
        this.allowTaskReparenting = allowTaskReparenting;
        return this;
    }

    public Boolean getAlwaysRetainTaskState() {
        return alwaysRetainTaskState;
    }

    public Activity setAlwaysRetainTaskState(Boolean alwaysRetainTaskState) {
        this.alwaysRetainTaskState = alwaysRetainTaskState;
        return this;
    }

    public Boolean getClearTaskOnLaunch() {
        return clearTaskOnLaunch;
    }

    public Activity setClearTaskOnLaunch(Boolean clearTaskOnLaunch) {
        this.clearTaskOnLaunch = clearTaskOnLaunch;
        return this;
    }

    public List<String> getConfigChanges() {
        return configChanges;
    }

    public Activity addConfigChange(String configChange) {
        configChanges.add(configChange);
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Activity setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getExcludeFromRecents() {
        return excludeFromRecents;
    }

    public Activity setExcludeFromRecents(Boolean excludeFromRecents) {
        this.excludeFromRecents = excludeFromRecents;
        return this;
    }

    public Boolean getExported() {
        return exported;
    }

    public Activity setExported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public Boolean getFinishOnTaskLaunch() {
        return finishOnTaskLaunch;
    }

    public Activity setFinishOnTaskLaunch(Boolean finishOnTaskLaunch) {
        this.finishOnTaskLaunch = finishOnTaskLaunch;
        return this;
    }

    public Boolean getHardwareAccelerated() {
        return hardwareAccelerated;
    }

    public Activity setHardwareAccelerated(Boolean hardwareAccelerated) {
        this.hardwareAccelerated = hardwareAccelerated;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Activity setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Activity setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLaunchMode() {
        return launchMode;
    }

    public Activity setLaunchMode(String launchMode) {
        this.launchMode = launchMode;
        return this;
    }

    public Boolean getMultiprocess() {
        return multiprocess;
    }

    public Activity setMultiprocess(Boolean multiprocess) {
        this.multiprocess = multiprocess;
        return this;
    }

    public String getName() {
        return name;
    }

    public Activity setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getNoHistory() {
        return noHistory;
    }

    public Activity setNoHistory(Boolean noHistory) {
        this.noHistory = noHistory;
        return this;
    }

    public String getParentActivityName() {
        return parentActivityName;
    }

    public Activity setParentActivityName(String parentActivityName) {
        this.parentActivityName = parentActivityName;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public Activity setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public String getProcess() {
        return process;
    }

    public Activity setProcess(String process) {
        this.process = process;
        return this;
    }

    public String getScreenOrientation() {
        return screenOrientation;
    }

    public Activity setScreenOrientation(String screenOrientation) {
        this.screenOrientation = screenOrientation;
        return this;
    }

    public Boolean getStateNotNeeded() {
        return stateNotNeeded;
    }

    public Activity setStateNotNeeded(Boolean stateNotNeeded) {
        this.stateNotNeeded = stateNotNeeded;
        return this;
    }

    public String getTaskAffinity() {
        return taskAffinity;
    }

    public Activity setTaskAffinity(String taskAffinity) {
        this.taskAffinity = taskAffinity;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public Activity setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getUiOptions() {
        return uiOptions;
    }

    public Activity setUiOptions(String uiOptions) {
        this.uiOptions = uiOptions;
        return this;
    }

    public List<String> getWindowSoftInputMode() {
        return windowSoftInputMode;
    }

    public Activity addWindowSoftInputMode(String windowSoftInputMode) {
        this.windowSoftInputMode.add(windowSoftInputMode);
        return this;
    }

    public List<IntentFilter> getIntentFilterList() {
        return intentFilterList;
    }

    public Activity addIntentFilter(IntentFilter intentFilter) {
        intentFilterList.add(intentFilter);
        return this;
    }

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public Activity addMetaData(MetaData metaData) {
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

        builder.append(indent).append("<activity \n");

        if (allowTaskReparenting != null) {
            builder.append(indent).append("\tandroid:allowTaskReparenting=\"").append(allowTaskReparenting).append("\" \n");
        }
        if (alwaysRetainTaskState != null) {
            builder.append(indent).append("\tandroid:alwaysRetainTaskState=\"").append(alwaysRetainTaskState).append("\" \n");
        }
        if (clearTaskOnLaunch != null) {
            builder.append(indent).append("\tandroid:clearTaskOnLaunch=\"").append(clearTaskOnLaunch).append("\" \n");
        }
        if (configChanges.size() > 0) {
            builder.append(indent).append("\tandroid:enabled=\"");
            int i = 0;
            for (String configChange : configChanges) {
                if (i > 0) {
                    builder.append("|");
                }
                builder.append(configChange);
                i++;
            }
            builder.append("\" \n");
        }
        if (enabled != null) {
            builder.append(indent).append("\tandroid:enabled=\"").append(enabled).append("\" \n");
        }
        if (excludeFromRecents != null) {
            builder.append(indent).append("\tandroid:excludeFromRecents=\"").append(excludeFromRecents).append("\" \n");
        }
        if (exported != null) {
            builder.append(indent).append("\tandroid:exported=\"").append(exported).append("\" \n");
        }
        if (finishOnTaskLaunch != null) {
            builder.append(indent).append("\tandroid:finishOnTaskLaunch=\"").append(finishOnTaskLaunch).append("\" \n");
        }
        if (hardwareAccelerated != null) {
            builder.append(indent).append("\tandroid:hardwareAccelerated=\"").append(hardwareAccelerated).append("\" \n");
        }
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (launchMode != null) {
            builder.append(indent).append("\tandroid:launchMode=\"").append(launchMode).append("\" \n");
        }
        if (multiprocess != null) {
            builder.append(indent).append("\tandroid:multiprocess=\"").append(multiprocess).append("\" \n");
        }
        if (name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if (noHistory != null) {
            builder.append(indent).append("\tandroid:noHistory=\"").append(noHistory).append("\" \n");
        }
        if (parentActivityName != null) {
            builder.append(indent).append("\tandroid:parentActivityName=\"").append(parentActivityName).append("\" \n");
        }
        if (permission != null) {
            builder.append(indent).append("\tandroid:permission=\"").append(permission).append("\" \n");
        }
        if (process != null) {
            builder.append(indent).append("\tandroid:process=\"").append(process).append("\" \n");
        }
        if (screenOrientation != null) {
            builder.append(indent).append("\tandroid:screenOrientation=\"").append(screenOrientation).append("\" \n");
        }
        if (stateNotNeeded != null) {
            builder.append(indent).append("\tandroid:stateNotNeeded=\"").append(stateNotNeeded).append("\" \n");
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
        if (windowSoftInputMode.size() > 0) {
            builder.append(indent).append("\tandroid:enabled=\"");
            int i = 0;
            for (String windowSoftInputMode : this.windowSoftInputMode) {
                if (i > 0) {
                    builder.append("|");
                }
                builder.append(windowSoftInputMode);
            }
            builder.append("\" \n");
        }

        builder.append(indent).append(">\n");

        for (IntentFilter intentFilter : intentFilterList) {
            builder.append(intentFilter.toXmlString(indent + "\t"));
        }

        for (MetaData metaData : metaDataList) {
            builder.append(metaData.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</activity>\n");

        return builder.toString();
    }

    public interface ConfigChanges {
        public static final String MCC = "mcc";
        public static final String MNC = "mnc";
        public static final String LOCALE = "locale";
        public static final String TOUCHSCREEN = "touchscreen";
        public static final String KEYBOARD = "keyboard";
        public static final String KEYBOARD_HIDDEN = "keyboardHidden";
        public static final String NAVIGATION = "navigation";
        public static final String SCREEN_LAYOUT = "screenLayout";
        public static final String FONT_SCALE = "fontScale";
        public static final String UI_MODE = "uiMode";
        public static final String ORIENTATION = "orientation";
        public static final String SCREEN_SIZE = "screenSize";
        public static final String SMALLEST_SCREEN_SIZE = "smallestScreenSize";
    }

    public interface LaunchMode {
        public static final String STANDARD = "standard";
        public static final String SINGLE_TOP = "singleTop";
        public static final String SINGLE_TASK = "singleTask";
        public static final String SINGLE_INSTANCE = "singleInstance";
    }

    public interface ScreenOrientation {
        public static final String UNSPECIFIED = "unspecified";
        public static final String USER = "user";
        public static final String BEHIND = "behind";
        public static final String LANDSCAPE = "landscape";
        public static final String PORTRAIT = "portrait";
        public static final String REVERSE_LANDSCAPE = "reverseLandscape";
        public static final String REVERSE_PORTRAIT = "reversePortrait";
        public static final String SENSOR_LANDSCAPE = "sensorLandscape";
        public static final String SENSOR_PORTRAIT = "sensorPortrait";
        public static final String SENSOR = "sensor";
        public static final String FULL_SENSOR = "fullSensor";
        public static final String NOSENSOR = "nosensor";
    }

    public interface UiOptions {
        public static final String NONE = "none";
        public static final String SPLIT_ACTION_BAR_WHEN_NARROW = "splitActionBarWhenNarrow";
    }

    public interface WindowSoftInputMode {
        public static final String STATE_UNSPECIFIED = "stateUnspecified";
        public static final String STATE_UNCHANGED = "stateUnchanged";
        public static final String STATE_HIDDEN = "stateHidden";
        public static final String STATE_ALWAYS_HIDDEN = "stateAlwaysHidden";
        public static final String STATE_VISIBLE = "stateVisible";
        public static final String STATE_ALWAYS_VISIBLE = "stateAlwaysVisible";
        public static final String ADJUST_UNSPECIFIED = "adjustUnspecified";
        public static final String ADJUST_RESIZE = "adjustResize";
        public static final String ADJUST_PAN = "adjustPan";
    }
}
