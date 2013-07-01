package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class UsesFeature implements Node {

    private String name = null;
    private Boolean required = null;
    private Integer glEsVersion = null;

    public String getName() {
        return name;
    }

    public UsesFeature setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getRequired() {
        return required;
    }

    public UsesFeature setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Integer getGlEsVersion() {
        return glEsVersion;
    }

    public UsesFeature setGlEsVersion(Integer glEsVersion) {
        this.glEsVersion = glEsVersion;
        return this;
    }

    @Override
    public void validate() {
        if(name == null) {
            throw new IllegalStateException("Attribute \"name\" mustn't be null!");
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-feature \n");

        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(required != null) {
            builder.append(indent).append("\tandroid:required=\"").append(required).append("\" \n");
        }
        if(glEsVersion != null) {
            builder.append(indent).append("\tandroid:glEsVersion=\"").append(glEsVersion).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
