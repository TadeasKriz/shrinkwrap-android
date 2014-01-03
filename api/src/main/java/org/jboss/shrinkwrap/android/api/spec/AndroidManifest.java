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
package org.jboss.shrinkwrap.android.api.spec;

import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.android.api.spec.node.Manifest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class AndroidManifest extends Manifest implements Asset {

    public String toXmlString() {
        return super.toXmlString("");
    }

    @Override
    public InputStream openStream() {
        return new ByteArrayInputStream(toXmlString().getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public String toString() {
        return toXmlString();
    }

    public interface Builder {

        // TODO do we need builder?

    }

}
