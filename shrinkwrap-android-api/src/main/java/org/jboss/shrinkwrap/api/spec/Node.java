package org.jboss.shrinkwrap.api.spec;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public interface Node {
    public void validate();

    public String toXmlString(String indent);
}