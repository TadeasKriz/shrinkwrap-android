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

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.container.ClassContainer;
import org.jboss.shrinkwrap.api.container.ResourceContainer;

import java.io.File;
import java.net.URL;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public interface AndroidArchive extends Archive<AndroidArchive>, ResourceContainer<AndroidArchive>,
    ClassContainer<AndroidArchive> {

    public AndroidArchive addAsAndroidManifest(String resourceName);

    public AndroidArchive addAsAndroidManifest(File resource);

    public AndroidArchive addAsAndroidManifest(URL resource);

    public AndroidArchive addAsAndroidManifest(Asset resource);

    /*
     * public AndroidArchive addAsResource(String resourceName, String target);
     *
     * public AndroidArchive addAsResource(File resource, String target);
     *
     * public AndroidArchive addAsResource(URL resource, String target);
     *
     * public AndroidArchive addAsResource(Asset resource, String target);
     *
     * public AndroidArchive addAsResource(String resourceName, ArchivePath target);
     *
     * public AndroidArchive addAsResource(File resource, ArchivePath target);
     *
     * public AndroidArchive addAsResource(URL resource, ArchivePath target);
     *
     * public AndroidArchive addAsResource(Asset resource, ArchivePath target);
     */
    public AndroidArchive addAsAsset(String resourceName, String target);

    public AndroidArchive addAsAsset(File resource, String target);

    public AndroidArchive addAsAsset(URL resource, String target);

    public AndroidArchive addAsAsset(Asset resource, String target);

    public AndroidArchive addAsAsset(String resourceName, ArchivePath target);

    public AndroidArchive addAsAsset(File resource, ArchivePath target);

    public AndroidArchive addAsAsset(URL resource, ArchivePath target);

    public AndroidArchive addAsAsset(Asset resource, ArchivePath target);

}
