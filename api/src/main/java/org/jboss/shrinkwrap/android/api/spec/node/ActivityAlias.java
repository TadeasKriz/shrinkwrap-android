package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class ActivityAlias implements XmlNode {

    private Boolean enabled = null;
    private Boolean exported = null;
    private String icon = null;
    private String label = null;
    private String name = null;
    private String permission = null;
    private String targetActivity = null;

    private List<IntentFilter> intentFilterList = new ArrayList<IntentFilter>();
    private List<MetaData> metaDataList = new ArrayList<MetaData>();

    public Boolean getEnabled() {
        return enabled;
    }

    public ActivityAlias setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getExported() {
        return exported;
    }

    public ActivityAlias setExported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public ActivityAlias setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ActivityAlias setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getName() {
        return name;
    }

    public ActivityAlias setName(String name) {
        this.name = name;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public ActivityAlias setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public String getTargetActivity() {
        return targetActivity;
    }

    public ActivityAlias setTargetActivity(String targetActivity) {
        this.targetActivity = targetActivity;
        return this;
    }

    public List<IntentFilter> getIntentFilterList() {
        return intentFilterList;
    }

    public ActivityAlias addIntentFilter(IntentFilter intentFilter) {
        intentFilterList.add(intentFilter);
        return this;
    }

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public ActivityAlias addMetaData(MetaData metaData) {
        metaDataList.add(metaData);
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation

        for(IntentFilter intentFilter : intentFilterList) {
            intentFilter.validate();
        }

        for(MetaData metaData : metaDataList) {
            metaData.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<activity-alias \n");

        if(enabled != null) {
            builder.append(indent).append("\tandroid:enabled=\"").append(enabled).append("\" \n");
        }
        if(exported != null) {
            builder.append(indent).append("\tandroid:exported=\"").append(exported).append("\" \n");
        }
        if(icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if(label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(permission != null) {
            builder.append(indent).append("\tandroid:permission=\"").append(permission).append("\" \n");
        }
        if(targetActivity != null) {
            builder.append(indent).append("\tandroid:targetActivity=\"").append(targetActivity).append("\" \n");
        }

        builder.append(indent).append(">\n");

        for(IntentFilter intentFilter : intentFilterList) {
            builder.append(intentFilter.toXmlString(indent + "\t"));
        }

        for(MetaData metaData : metaDataList) {
            builder.append(metaData.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</activity-alias>\n");

        return builder.toString();
    }
}
