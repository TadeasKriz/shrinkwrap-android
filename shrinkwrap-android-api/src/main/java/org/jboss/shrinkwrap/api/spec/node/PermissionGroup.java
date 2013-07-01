package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class PermissionGroup implements Node {

    private String description = null;
    private String icon = null;
    private String label = null;
    private String name = null;

    /**
     * User-readable text that describes the group. The text should be longer and more explanatory than the label. This attribute must be set as a reference to a string resource. Unlike the label attribute, it cannot be a raw string.
     */
    public String getDescription() {
        return description;
    }

    public PermissionGroup setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * An icon representing the permission. This attribute must be set as a reference to a drawable resource containing the image definition.
     */
    public String getIcon() {
        return icon;
    }

    public PermissionGroup setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * A user-readable name for the group. As a convenience, the label can be directly set as a raw string while you're developing the application. However, when the application is ready to be published, it should be set as a reference to a string resource, so that it can be localized like other strings in the user interface.
     */
    public String getLabel() {
        return label;
    }

    public PermissionGroup setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * The name of the group. This is the name that can be assigned to a &lt;permission&gt; element's &lt;permissionGroup&gt; attribute.
     */
    public String getName() {
        return name;
    }

    public PermissionGroup setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void validate() {
        if(name == null) {
            throw new IllegalStateException("Attribute \"name\" mustn't be null!");
        }
    }

    /**
     * @return xml representation of this PermissionGroup.
     * @param indent
     */
    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<permission-group \n");
        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if(description != null) {
            builder.append(indent).append("\tandroid:description=\"").append(description).append("\" \n");
        }
        if(icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
