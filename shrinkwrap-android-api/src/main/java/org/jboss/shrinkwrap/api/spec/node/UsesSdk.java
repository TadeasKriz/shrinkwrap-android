package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class UsesSdk implements Node {

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
        // TODO add validation
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-sdk \n");

        if(minSdkversion != null) {
            builder.append(indent).append("\tandroid:minSdkVersion=\"").append(minSdkversion).append("\" \n");
        }
        if(targetSdkVersion != null) {
            builder.append(indent).append("\tandroid:targetSdkVersion=\"").append(targetSdkVersion).append("\" \n");
        }
        if(maxSdkVersion != null) {
            builder.append(indent).append("\tandroid:maxSdkVersion=\"").append(maxSdkVersion).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
