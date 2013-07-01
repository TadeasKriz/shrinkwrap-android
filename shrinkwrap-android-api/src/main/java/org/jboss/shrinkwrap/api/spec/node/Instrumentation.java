package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class Instrumentation implements Node {

    private Boolean functionalTest = null;
    private Boolean handleProfiling = null;
    private String icon = null;
    private String label = null;
    private String name = null;
    private String targetPackage = null;

    public Boolean getFunctionalTest() {
        return functionalTest;
    }

    public Instrumentation setFunctionaltest(Boolean functionaltest) {
        this.functionalTest = functionaltest;
        return this;
    }

    public Boolean getHandleProfiling() {
        return handleProfiling;
    }

    public Instrumentation setHandleProfiling(Boolean handleProfiling) {
        this.handleProfiling = handleProfiling;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Instrumentation setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Instrumentation setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getName() {
        return name;
    }

    public Instrumentation setName(String name) {
        this.name = name;
        return this;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public Instrumentation setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
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

        builder.append(indent).append("<instrumentation \n");
        if(functionalTest != null) {
            builder.append(indent).append("\tandroid:functionalTest=\"").append(functionalTest).append("\" \n");
        }
        if(handleProfiling != null) {
            builder.append(indent).append("\tandroid:handleProfiling=\"").append(handleProfiling).append("\" \n");
        }
        if(icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if(label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if(name != null) {
            builder.append(indent).append("\tandroid:name=\"").append(name).append("\" \n");
        }
        if(targetPackage != null) {
            builder.append(indent).append("\tandroid:targetPackage=\"").append(targetPackage).append("\" \n");
        }
        builder.append(indent).append("/>\n");

        return builder.toString();
    }

}
