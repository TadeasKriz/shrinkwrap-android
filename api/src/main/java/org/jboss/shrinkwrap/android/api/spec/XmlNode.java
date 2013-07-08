package org.jboss.shrinkwrap.android.api.spec;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public interface XmlNode {
    public void validate();

    public String toXmlString(String indent);
}