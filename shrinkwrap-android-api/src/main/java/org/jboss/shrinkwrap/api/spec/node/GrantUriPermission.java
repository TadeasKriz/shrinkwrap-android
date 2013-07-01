package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class GrantUriPermission implements Node {

    private String path = null;
    private String pathPattern = null;
    private String pathPrefix = null;

    public String getPath() {
        return path;
    }

    public GrantUriPermission setPath(String path) {
        this.path = path;
        return this;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public GrantUriPermission setPathPattern(String pathPattern) {
        this.pathPattern = pathPattern;
        return this;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public GrantUriPermission setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<grant-uri-permission \n");

        if(path != null) {
            builder.append(indent).append("\tandroid:path=\"").append(path).append("\" \n");
        }
        if(pathPattern != null) {
            builder.append(indent).append("\tandroid:pathPattern=\"").append(pathPattern).append("\" \n");
        }
        if(pathPrefix != null) {
            builder.append(indent).append("\tandroid:pathPrefix=\"").append(pathPrefix).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
