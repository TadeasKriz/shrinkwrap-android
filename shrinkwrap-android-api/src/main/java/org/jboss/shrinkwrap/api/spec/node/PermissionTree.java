package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class PermissionTree implements Node {

    private String icon = null;
    private String label = null;
    private String name = null;

    /**
     * An icon representing all the permissions in the tree. This attribute must be set as a reference to a drawable resource containing the image definition.
     */
    public String getIcon() {
        return icon;
    }

    public PermissionTree setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * A user-readable name for the group. As a convenience, the label can be directly set as a raw string for a quick and dirty programming. However, when the application is ready to be published, it should be set as a reference to a string resource, so that it can be localized like other strings in the user interface.
     */
    public String getLabel() {
        return label;
    }

    public PermissionTree setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * The name that's at the base of the permission tree. It serves as a prefix to all permission names in the tree. Java-style scoping should be used to ensure that the name is unique. The name must have more than two period-separated segments in its path - for example, com.example.base is OK, but com.example is not.
     */
    public String getName() {
        return name;
    }

    public PermissionTree setName(String name) {
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
     * @return xml representation of this PermissionTree
     * @param indent
     */
    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<permission-tree \n");
        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if(icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
