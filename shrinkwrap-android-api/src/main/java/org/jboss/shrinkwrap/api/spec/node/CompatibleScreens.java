package org.jboss.shrinkwrap.api.spec.node;

import org.jboss.shrinkwrap.api.spec.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class CompatibleScreens implements Node {

    private List<Screen> screenList = new ArrayList<Screen>();

    public List<Screen> getScreenList() {
        return screenList;
    }

    public CompatibleScreens addScreen(Screen screen) {
        this.screenList.add(screen);
        return this;
    }

    @Override
    public void validate() {
        for(Screen screen : screenList) {
            screen.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<compatible-screens>\n");
        for(Screen screen : screenList) {
            builder.append(screen.toXmlString(indent + "\t"));
        }
        builder.append(indent).append("</compatible-screens>\n");

        return builder.toString();
    }

    public static class Screen implements Node {

        private String screenSize = null;
        private String screenDensity = null;

        public String getScreenSize() {
            return screenSize;
        }

        public Screen setScreenSize(String screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public String getScreenDensity() {
            return screenDensity;
        }

        public Screen setScreenDensity(String screenDensity) {
            this.screenDensity = screenDensity;
            return this;
        }

        @Override
        public void validate() {
            if(screenSize == null) {
                throw new IllegalStateException("Attribute \"screenSize\" mustn't be null!");
            }
            if(screenDensity == null) {
                throw new IllegalStateException("Attribute \"screenDensity\" mustn't be null!");
            }
        }

        @Override
        public String toXmlString(String indent) {
            StringBuilder builder = new StringBuilder();

            builder.append(indent).append("<screen \n");
            if(screenSize != null) {
                builder.append(indent).append("\tandroid:screenSize=\"").append(screenSize).append("\" \n");
            }
            if(screenDensity != null) {
                builder.append(indent).append("\tandroid:screenDensity=\"").append(screenDensity).append("\" \n");
            }
            builder.append(indent).append("/>");

            return builder.toString();
        }
    }

    public interface ScreenSize {
        public static final String SMALL = "small";
        public static final String NORMAL = "normal";
        public static final String LARGE = "large";
        public static final String XLARGE = "xlarge";
    }

    public interface ScreenDensity {
        public static final String LDPI = "ldpi";
        public static final String MDPI = "mdpi";
        public static final String HDPI = "hdpi";
        public static final String XHDPI = "xhdpi";
    }

}
