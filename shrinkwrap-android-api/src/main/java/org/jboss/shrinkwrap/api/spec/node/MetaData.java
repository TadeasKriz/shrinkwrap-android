package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class MetaData implements Node {

    private String name = null;
    private String resource = null;
    private String value = null;

    public String getName() {
        return name;
    }

    public MetaData setName(String name) {
        this.name = name;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public MetaData setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public String getValue() {
        return value;
    }

    public MetaData setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public void validate() {
        if(name == null) {
            throw new IllegalStateException("Attribute \"name\" mustn't be null!");
        }
        if(resource == null && value == null) {
            throw new IllegalStateException("Both \"resource\" and \"value\" attributes are null!");
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<meta-data \n");
        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(resource != null) {
            builder.append(indent).append("\tandroid:resource=\"").append(resource).append("\" \n");
        }
        if(value != null) {
            builder.append(indent).append("\tandroid:value=\"").append(value).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
