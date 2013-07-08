package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class UsesPermission implements XmlNode {

    private String name = null;

    /**
     * The name of the permission. It can be a permission defined by the application with the &lt;permission&gt; element, a permission defined by another application, or one of the standard system permissions, such as "android.permission.CAMERA" or "android.permission.READ_CONTACTS". As these examples show, a permission name typically includes the package name as a prefix.
     */
    public String getName() {
        return name;
    }

    public UsesPermission setName(String name) {
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
     * @return xml representation of this UsesPermission
     * @param indent
     */
    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-permission \n");

        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }
}
