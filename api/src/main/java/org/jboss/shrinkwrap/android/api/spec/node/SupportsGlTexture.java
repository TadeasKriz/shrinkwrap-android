package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class SupportsGlTexture implements XmlNode {

    private String name = null;

    public String getName() {
        return name;
    }

    public SupportsGlTexture setName(String name) {
        this.name = name;
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

        builder.append(indent).append("<supports-gl-texture \n");

        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
