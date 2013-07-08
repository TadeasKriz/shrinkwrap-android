package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class PathPermission implements XmlNode {

    private String path = null;
    private String pathPrefix = null;
    private String pathPattern = null;
    private String permission = null;
    private String readPermission = null;
    private String writePermission = null;

    public String getPath() {
        return path;
    }

    public PathPermission setPath(final String path) {
        this.path = path;
        return this;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public PathPermission setPathPrefix(final String pathPrefix) {
        this.pathPrefix = pathPrefix;
        return this;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public PathPermission setPathPattern(final String pathPattern) {
        this.pathPattern = pathPattern;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public PathPermission setPermission(final String permission) {
        this.permission = permission;
        return this;
    }

    public String getReadPermission() {
        return readPermission;
    }

    public PathPermission setReadPermission(final String readPermission) {
        this.readPermission = readPermission;
        return this;
    }

    public String getWritePermission() {
        return writePermission;
    }

    public PathPermission setWritePermission(final String writePermission) {
        this.writePermission = writePermission;
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<path-permission \n");
        if(path != null) {
            builder.append(indent).append("android:path=\"").append(path).append("\" \n");
        }
        if(pathPrefix != null) {
            builder.append(indent).append("android:pathPrefix=\"").append(pathPrefix).append("\" \n");
        }
        if(pathPattern != null) {
            builder.append(indent).append("android:pathPattern=\"").append(pathPattern).append("\" \n");
        }
        if(permission != null) {
            builder.append(indent).append("android:permission=\"").append(permission).append("\" \n");
        }
        if(readPermission != null) {
            builder.append(indent).append("android:readPermission=\"").append(readPermission).append("\" \n");
        }
        if(writePermission != null) {
            builder.append(indent).append("android:writePermission=\"").append(writePermission).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
