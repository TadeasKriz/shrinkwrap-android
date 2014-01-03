/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.android.api.spec.node;

import org.jboss.shrinkwrap.android.api.spec.XmlNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class IntentFilter implements XmlNode {

    private String icon = null;
    private String label = null;
    private Integer priority = null;

    private List<Action> actionList = new ArrayList<Action>();
    private List<Category> categoryList = new ArrayList<Category>();
    private List<Data> dataList = new ArrayList<Data>();

    public String getIcon() {
        return icon;
    }

    public IntentFilter setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public IntentFilter setLabel(String label) {
        this.label = label;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public IntentFilter setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public IntentFilter addAction(Action action) {
        actionList.add(action);
        return this;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public IntentFilter addCategory(Category category) {
        categoryList.add(category);
        return this;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public IntentFilter addData(Data data) {
        dataList.add(data);
        return this;
    }

    @Override
    public void validate() {
        // TODO add validation

        for (Action action : actionList) {
            action.validate();
        }

        for (Category category : categoryList) {
            category.validate();
        }

        for (Data data : dataList) {
            data.validate();
        }
    }

    @Override
    public String toXmlString(String indent) {
        StringBuilder builder = new StringBuilder();

        builder.append(indent).append("<intent-filter \n");
        if (icon != null) {
            builder.append(indent).append("\tandroid:icon=\"").append(icon).append("\" \n");
        }
        if (label != null) {
            builder.append(indent).append("\tandroid:label=\"").append(label).append("\" \n");
        }
        if (priority != null) {
            builder.append(indent).append("\tandroid:priority=\"").append(priority).append("\" \n");
        }
        builder.append(indent).append(">\n");

        for (Action action : actionList) {
            builder.append(action.toXmlString(indent + "\t"));
        }

        for (Category category : categoryList) {
            builder.append(category.toXmlString(indent + "\t"));
        }

        for (Data data : dataList) {
            builder.append(data.toXmlString(indent + "\t"));
        }

        builder.append(indent).append("</intent-filter>\n");

        return builder.toString();
    }
}
