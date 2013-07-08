package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class UsesConfiguration implements XmlNode {

    private Boolean reqFiveWayNav = null;
    private Boolean reqHardKeyboard = null;
    private String reqKeyboardType = null;
    private String reqNavigation = null;
    private String reqTouchScreen = null;

    public boolean getReqFiveWayNav() {
        return reqFiveWayNav;
    }

    public UsesConfiguration setReqFiveWayNav(Boolean reqFiveWayNav) {
        this.reqFiveWayNav = reqFiveWayNav;
        return this;
    }

    public Boolean getReqHardKeyboard() {
        return reqHardKeyboard;
    }

    public UsesConfiguration setReqHardKeyboard(Boolean reqHardKeyboard) {
        this.reqHardKeyboard = reqHardKeyboard;
        return this;
    }

    public String getReqKeyboardType() {
        return reqKeyboardType;
    }

    public UsesConfiguration setReqKeyboardType(String reqKeyboardType) {
        this.reqKeyboardType = reqKeyboardType;
        return this;
    }

    public String getReqNavigation() {
        return reqNavigation;
    }

    public UsesConfiguration setReqNavigation(String reqNavigation) {
        this.reqNavigation = reqNavigation;
        return this;
    }

    public String getReqTouchScreen() {
        return reqTouchScreen;
    }

    public UsesConfiguration setReqTouchScreen(String reqTouchScreen) {
        this.reqTouchScreen = reqTouchScreen;
        return this;
    }

    @Override
    public void validate() { }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<uses-configuration \n");

        if(reqFiveWayNav != null) {
            builder.append(indent).append("\tandroid:reqFiveWayNav=\"").append(reqFiveWayNav).append("\" \n");
        }
        if(reqHardKeyboard != null) {
            builder.append(indent).append("\tandroid:reqHardKeyboard=\"").append(reqHardKeyboard).append("\" \n");
        }
        if(reqKeyboardType != null) {
            builder.append(indent).append("\tandroid:reqKeyboardType=\"").append(reqKeyboardType).append("\" \n");
        }
        if(reqNavigation != null) {
            builder.append(indent).append("\tandroid:reqNavigation=\"").append(reqNavigation).append("\" \n");
        }
        if(reqTouchScreen != null) {
            builder.append(indent).append("\tandroid:reqTouchScreen=\"").append(reqTouchScreen).append("\" \n");
        }

        builder.append(indent).append("/>\n");

        return builder.toString();
    }

    public interface KeyboardType {
        public static final String UNDEFINED = "undefined";
        public static final String NOKEYS = "nokeys";
        public static final String QWERTY = "qwerty";
        public static final String TWELVEKEY = "twelvekey";
    }

    public interface Navigation {
        public static final String UNDEFINED = "undefined";
        public static final String NONAV = "nonav";
        public static final String DPAD = "dpad";
        public static final String TRACKBALL = "trackball";
        public static final String WHEEL = "wheel";
    }

    public interface TouchScreen {
        public static final String UNDEFINED = "undefined";
        public static final String NOTOUCH = "notouch";
        public static final String STYLUS = "stylus";
        public static final String FINGER = "finger";
    }
}