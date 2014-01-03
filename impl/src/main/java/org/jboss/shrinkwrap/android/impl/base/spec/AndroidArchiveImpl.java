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
package org.jboss.shrinkwrap.android.impl.base.spec;

import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.asset.*;
import org.jboss.shrinkwrap.api.exporter.StreamExporter;
import org.jboss.shrinkwrap.api.formatter.Formatter;
import org.jboss.shrinkwrap.android.api.spec.AndroidArchive;
import org.jboss.shrinkwrap.impl.base.AssignableBase;
import org.jboss.shrinkwrap.impl.base.URLPackageScanner;
import org.jboss.shrinkwrap.impl.base.Validate;
import org.jboss.shrinkwrap.impl.base.asset.AssetUtil;
import org.jboss.shrinkwrap.impl.base.path.BasicPath;
import org.jboss.shrinkwrap.spi.Configurable;

import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class AndroidArchiveImpl extends AssignableBase<Archive<?>> implements AndroidArchive {

    private static final String RESOURCE_DIRECTORY = "/res";
    private static final String ASSET_DIRECTORY = "/asset";
    private static final String AIDL_DIRECTORY = "/aidl";
    private static final String CLASS_DIRECTORY = "/class";

    private static final String ANDROID_MANIFEST = "AndroidManifest.xml";
    private static final String DEFAULT_PACKAGE_NAME = "";

    private String resourceDirectory = RESOURCE_DIRECTORY;
    private String assetDirectory = ASSET_DIRECTORY;
    private String aidlDirectory = AIDL_DIRECTORY;
    private String getClassDirectory = CLASS_DIRECTORY;

    public AndroidArchiveImpl(final Archive<?> archive) {
        super(archive);
    }

    @Override
    public AndroidArchive addAsAndroidManifest(String resourceName) {
        return addAsAndroidManifest(fileFromResource(resourceName));
    }

    @Override
    public AndroidArchive addAsAndroidManifest(File resource) {
        if (resource.isFile()) {
            return addAsAndroidManifest(new FileAsset(resource));
        } else {
            throw new IllegalArgumentException("AndroidManifest has to be single file!");
        }
    }

    @Override
    public AndroidArchive addAsAndroidManifest(URL resource) {
        File file = new File(resource.getFile());
        if (file.exists()) {
            return addAsAndroidManifest(file);
        }

        return addAsAndroidManifest(new UrlAsset(resource));
    }

    @Override
    public AndroidArchive addAsAndroidManifest(Asset resource) {
        ArchivePath location = new BasicPath(ANDROID_MANIFEST);
        return add(resource, location);
    }

    @Override
    public AndroidArchive addAsResource(String resourceName) throws IllegalArgumentException {
        return addAsResource(resourceName, resourceName);
    }

    @Override
    public AndroidArchive addAsResource(File resource) throws IllegalArgumentException {
        return addAsResource(resource, resource.getName());
    }

    @Override
    public AndroidArchive addAsResource(String resourceName, String target) {
        return addAsResource(fileFromResource(resourceName), target);
    }

    @Override
    public AndroidArchive addAsResource(File resource, String target) {
        return addAsResource(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsResource(URL resource, String target) {
        return addAsResource(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsResource(Asset resource, String target) {
        return addAsResource(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsResource(String resourceName, ArchivePath target) {
        return addAsResource(fileFromResource(resourceName), target);
    }

    @Override
    public AndroidArchive addAsResource(String resourceName, ArchivePath target, ClassLoader classLoader)
        throws IllegalArgumentException {
        return addAsResource(new ClassLoaderAsset(resourceName, classLoader), target);
    }

    @Override
    public AndroidArchive addAsResource(File resource, ArchivePath target) {
        if (resource.isFile()) {
            return addAsResource(new FileAsset(resource), target);
        }

        final File[] files = resource.listFiles();

        if (files == null) {

        }

        if (files.length == 0) {
            return addAsResource(new FileAsset(resource), target);
        }

        for (File file : files) {
            ArchivePath child = ArchivePaths.create(file.getName());
            addAsResource(file, new BasicPath(target, child));
        }

        return this;
    }

    @Override
    public AndroidArchive addAsResource(URL resource, ArchivePath target) {
        File file = new File(resource.getFile());
        if (file.exists()) {
            return addAsResource(file, target);
        }

        return addAsResource(new UrlAsset(resource), target);
    }

    @Override
    public AndroidArchive addAsResource(Asset resource, ArchivePath target) {
        ArchivePath location = new BasicPath(resourceDirectory, target);
        return add(resource, location);
    }

    @Override
    public AndroidArchive addAsResources(Package resourcePackage, String... resourceNames) throws IllegalArgumentException {
        for (String resourceName : resourceNames) {
            addAsResource(resourcePackage, resourceName);
        }
        return this;
    }

    @Override
    public AndroidArchive addAsResource(Package resourcePackage, String resourceName) throws IllegalArgumentException {
        String classLoaderResourceName = AssetUtil.getClassLoaderResourceName(resourcePackage, resourceName);
        ArchivePath target = ArchivePaths.create(classLoaderResourceName);

        return addAsResource(resourcePackage, resourceName, target);
    }

    @Override
    public AndroidArchive addAsResource(Package resourcePackage, String resourceName, String target)
        throws IllegalArgumentException {
        return addAsResource(resourcePackage, resourceName, ArchivePaths.create(target));
    }

    @Override
    public AndroidArchive addAsResource(Package resourcePackage, String resourceName, ArchivePath target)
        throws IllegalArgumentException {
        String classLoaderResourceName = AssetUtil.getClassLoaderResourceName(resourcePackage, resourceName);
        Asset resource = new ClassLoaderAsset(classLoaderResourceName);

        return addAsResource(resource, target);
    }

    @Override
    public AndroidArchive addAsAsset(String resourceName, String target) {
        return addAsAsset(fileFromResource(resourceName), target);
    }

    @Override
    public AndroidArchive addAsAsset(File resource, String target) {
        return addAsAsset(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsAsset(URL resource, String target) {
        return addAsAsset(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsAsset(Asset resource, String target) {
        return addAsAsset(resource, new BasicPath(target));
    }

    @Override
    public AndroidArchive addAsAsset(String resourceName, ArchivePath target) {
        return addAsAsset(fileFromResource(resourceName), target);
    }

    @Override
    public AndroidArchive addAsAsset(File resource, ArchivePath target) {
        if (resource.isFile()) {
            return addAsResource(new FileAsset(resource), target);
        }

        final File[] files = resource.listFiles();
        if (files == null) {

        }

        if (files.length == 0) {
            return addAsDirectory(new BasicPath(assetDirectory, target));
        }

        for (File file : files) {
            ArchivePath child = ArchivePaths.create(file.getName());
            addAsAsset(file, new BasicPath(target, child));
        }

        return this;
    }

    @Override
    public AndroidArchive addAsAsset(URL resource, ArchivePath target) {
        File file = new File(resource.getFile());
        if (file.exists()) {
            return addAsAsset(file, target);
        }

        return addAsAsset(new UrlAsset(resource), target);
    }

    @Override
    public AndroidArchive addAsAsset(Asset resource, ArchivePath target) {
        ArchivePath location = new BasicPath(assetDirectory, target);
        return add(resource, location);
    }

    @Override
    public AndroidArchive addClass(Class<?> clazz) throws IllegalArgumentException {
        return addClasses(clazz);
    }

    @Override
    public AndroidArchive addClass(String fullyQualifiedClassName) throws IllegalArgumentException {
        Iterable<ClassLoader> cls = getArchiveClassLoaders();
        assert cls != null : "CLs of this archie is not specified:" + getArchive();

        final Class<?> classToAdd;
        try {
            classToAdd = ClassLoaderSearchUtilDelegator.findClassFromClassLoaders(fullyQualifiedClassName, cls);
        } catch (final ClassNotFoundException e) {
            throw new IllegalArgumentException("Could not find the requested Class \"" + fullyQualifiedClassName
                + "\" in any of the configured ClassLoaders for this archive", e);
        }

        return addClass(classToAdd);
    }

    @Override
    public AndroidArchive addClass(String fullyQualifiedClassName, ClassLoader classLoader) throws IllegalArgumentException {
        final Class<?> classToAdd;
        try {
            classToAdd = Class.forName(fullyQualifiedClassName, false, classLoader);
        } catch (final ClassNotFoundException e) {
            throw new IllegalArgumentException("Could not load class of name \"" + fullyQualifiedClassName + "\" with \""
                + classLoader + "\"", e);
        }

        return addClass(classToAdd);
    }

    @Override
    public AndroidArchive addClasses(Class<?>... classes) throws IllegalArgumentException {
        for (final Class<?> clazz : classes) {
            Asset resource = new ClassAsset(clazz);
            ArchivePath location = new BasicPath(CLASS_DIRECTORY, AssetUtil.getFullPathForClassResource(clazz));
            add(resource, location);

            final ClassLoader loadingCl = clazz.getClassLoader();
            final ClassLoader adjustedCl = loadingCl == null ? ClassLoader.getSystemClassLoader() : loadingCl;

            addPackages(false, new Filter<ArchivePath>() {
                @Override
                public boolean include(ArchivePath path) {
                    ArchivePath classArchivePath = AssetUtil.getFullPathForClassResource(clazz);
                    String expression = classArchivePath.get().replace(".class", "\\$.*");
                    return path.get().matches(expression);
                }
            }, adjustedCl, clazz.getPackage() == null ? DEFAULT_PACKAGE_NAME : clazz.getPackage().getName());

        }

        return this;
    }

    @Override
    public AndroidArchive addPackage(Package pack) throws IllegalArgumentException {
        return addPackage(pack.getName());
    }

    @Override
    public AndroidArchive addDefaultPackage() {
        return addPackages(false, DEFAULT_PACKAGE_NAME);
    }

    @Override
    public AndroidArchive addPackages(boolean recursive, Package... packages) throws IllegalArgumentException {
        return addPackages(recursive, Filters.includeAll(), packages);
    }

    @Override
    public AndroidArchive addPackages(boolean recursive, Filter<ArchivePath> archivePathFilter, Package... packages)
        throws IllegalArgumentException {
        return addPackages(recursive, archivePathFilter, null, packages);
    }

    private AndroidArchive addPackages(boolean recursive, Filter<ArchivePath> archivePathFilter, ClassLoader classLoader,
        Package... packages) throws IllegalArgumentException {
        String[] packageNames = new String[packages.length];
        for (int i = 0; i < packages.length; i++) {
            packageNames[i] = packages[i] == null ? null : packages[i].getName();
        }

        if (classLoader == null) {
            return addPackages(recursive, archivePathFilter, packageNames);
        }

        return addPackages(recursive, archivePathFilter, classLoader, packageNames);
    }

    @Override
    public AndroidArchive addPackage(String pack) throws IllegalArgumentException {
        return addPackages(false, pack);
    }

    @Override
    public AndroidArchive addPackages(boolean recursive, String... packages) throws IllegalArgumentException {
        return addPackages(recursive, Filters.includeAll(), packages);
    }

    @Override
    public AndroidArchive addPackages(boolean recursive, Filter<ArchivePath> archivePathFilter, String... packageNames)
        throws IllegalArgumentException {
        final Iterable<ClassLoader> classLoaders = getArchiveClassLoaders();

        for (String packageName : packageNames) {
            for (final ClassLoader classLoader : classLoaders) {
                addPackage(recursive, archivePathFilter, classLoader, packageName);
            }
        }

        return this;
    }

    private AndroidArchive addPackages(boolean recursive, Filter<ArchivePath> filter, ClassLoader classLoader,
        String... packageNames) {
        for (String packageName : packageNames) {
            addPackage(recursive, filter, classLoader, packageName);
        }
        return this;
    }

    private void addPackage(boolean recursive, final Filter<ArchivePath> filter, final ClassLoader classLoader,
        String packageName) {
        final URLPackageScanner.Callback callback = new URLPackageScanner.Callback() {
            @Override
            public void classFound(String className) {
                ArchivePath classNamePath = AssetUtil.getFullPathForClassResource(className);
                if (!filter.include(classNamePath)) {
                    return;
                }
                Asset asset = new ClassLoaderAsset(classNamePath.get().substring(1), classLoader);
                ArchivePath location = new BasicPath(CLASS_DIRECTORY, classNamePath);
                add(asset, location);
            }
        };
        final URLPackageScanner scanner = URLPackageScanner.newInstance(recursive, classLoader, callback, packageName);
        scanner.scanPackage();
    }

    @Override
    public AndroidArchive deleteClass(Class<?> clazz) throws IllegalArgumentException {
        return deleteClasses(clazz);
    }

    @Override
    public AndroidArchive deleteClass(String fullyQualifiedClassName) throws IllegalArgumentException {
        ArchivePath path = new BasicPath(CLASS_DIRECTORY, AssetUtil.getFullPathForClassResource(fullyQualifiedClassName));

        getArchive().delete(path);

        return this;
    }

    @Override
    public AndroidArchive deleteClasses(Class<?>... classes) throws IllegalArgumentException {
        for (Class<?> clazz : classes) {
            final ArchivePath path = new BasicPath(CLASS_DIRECTORY, AssetUtil.getFullPathForClassResource(clazz));

            for (ArchivePath innerPath : getInnerClasses(path)) {
                getArchive().delete(innerPath);
            }

            getArchive().delete(path);
        }

        return this;
    }

    private Set<ArchivePath> getInnerClasses(final ArchivePath path) {
        Map<ArchivePath, Node> content = getContent(new Filter<ArchivePath>() {
            @Override
            public boolean include(ArchivePath object) {
                String expression = path.get().replace(".class", "\\$.*");

                return object.get().matches(expression);
            }
        });

        return content.keySet();
    }

    @Override
    public AndroidArchive deletePackage(Package pack) throws IllegalArgumentException {
        return deletePackages(false, pack);
    }

    @Override
    public AndroidArchive deletePackage(String pack) throws IllegalArgumentException {
        return deletePackages(false, pack);
    }

    @Override
    public AndroidArchive deleteDefaultPackage() {
        return deletePackage(DEFAULT_PACKAGE_NAME);
    }

    @Override
    public AndroidArchive deletePackages(boolean recursive, Package... packages) throws IllegalArgumentException {
        return deletePackages(recursive, Filters.includeAll(), packages);
    }

    @Override
    public AndroidArchive deletePackages(boolean recursive, String... packages) throws IllegalArgumentException {
        return deletePackages(recursive, Filters.includeAll(), packages);
    }

    @Override
    public AndroidArchive deletePackages(boolean recursive, Filter<ArchivePath> archivePathFilter, Package... packages)
        throws IllegalArgumentException {

        String[] packagesName = new String[packages.length];

        for (int i = 0; i < packages.length; i++) {
            packagesName[i] = packages[i].getName();
        }

        return deletePackages(recursive, archivePathFilter, packagesName);
    }

    @Override
    public AndroidArchive deletePackages(boolean recursive, Filter<ArchivePath> archivePathFilter, String... packages)
        throws IllegalArgumentException {

        for (String packageName : packages) {
            for (ClassLoader cl : getArchiveClassLoaders()) {
                deletePackage(recursive, archivePathFilter, packageName, cl);
            }
        }

        return this;
    }

    private void deletePackage(boolean recursive, final Filter<ArchivePath> filter, String packageName, ClassLoader classLoader) {
        final URLPackageScanner.Callback callback = new URLPackageScanner.Callback() {
            @Override
            public void classFound(String className) {
                ArchivePath classNamePath = AssetUtil.getFullPathForClassResource(className);

                if (!filter.include(classNamePath)) {
                    return;
                }

                ArchivePath location = new BasicPath(CLASS_DIRECTORY, classNamePath);
                delete(location);
            }
        };

        final URLPackageScanner scanner = URLPackageScanner.newInstance(recursive, classLoader, callback, packageName);
        scanner.scanPackage();
    }

    @Override
    public String getName() {
        return getArchive().getName();
    }

    @Override
    public String getId() {
        return getArchive().getId();
    }

    @Override
    public AndroidArchive add(Asset asset, ArchivePath archivePath) throws IllegalArgumentException {
        getArchive().add(asset, archivePath);
        return this;
    }

    @Override
    public AndroidArchive add(Asset asset, ArchivePath archivePath, String s) throws IllegalArgumentException {
        getArchive().add(asset, archivePath, s);
        return this;
    }

    @Override
    public AndroidArchive add(Asset asset, String target, String name) throws IllegalArgumentException {
        getArchive().add(asset, target, name);
        return this;
    }

    @Override
    public AndroidArchive add(NamedAsset namedAsset) throws IllegalArgumentException {
        getArchive().add(namedAsset);
        return this;
    }

    @Override
    public AndroidArchive add(Asset asset, String name) throws IllegalArgumentException {
        getArchive().add(asset, name);
        return this;
    }

    @Override
    public AndroidArchive addAsDirectory(String path) throws IllegalArgumentException {
        getArchive().addAsDirectory(path);
        return this;
    }

    @Override
    public AndroidArchive addAsDirectories(String... paths) throws IllegalArgumentException {
        getArchive().addAsDirectories(paths);
        return this;
    }

    @Override
    public AndroidArchive addAsDirectory(ArchivePath archivePath) throws IllegalArgumentException {
        getArchive().addAsDirectory(archivePath);
        return this;
    }

    @Override
    public AndroidArchive addAsDirectories(ArchivePath... archivePaths) throws IllegalArgumentException {
        getArchive().addAsDirectories(archivePaths);
        return this;
    }

    @Override
    public AndroidArchive addHandlers(ArchiveEventHandler... handlers) {
        getArchive().addHandlers(handlers);
        return this;
    }

    @Override
    public Node get(ArchivePath archivePath) throws IllegalArgumentException {
        return getArchive().get(archivePath);
    }

    @Override
    public Node get(String path) throws IllegalArgumentException {
        return getArchive().get(path);
    }

    @Override
    public <X extends Archive<X>> X getAsType(Class<X> type, String path) {
        return getArchive().getAsType(type, path);
    }

    @Override
    public <X extends Archive<X>> X getAsType(Class<X> type, ArchivePath archivePath) {
        return getArchive().getAsType(type, archivePath);
    }

    @Override
    public <X extends Archive<X>> Collection<X> getAsType(Class<X> type, Filter<ArchivePath> archivePathFilter) {
        return getArchive().getAsType(type, archivePathFilter);
    }

    @Override
    public <X extends Archive<X>> X getAsType(Class<X> type, String path, ArchiveFormat archiveFormat) {
        return getArchive().getAsType(type, path, archiveFormat);
    }

    @Override
    public <X extends Archive<X>> X getAsType(Class<X> type, ArchivePath archivePath, ArchiveFormat archiveFormat) {
        return getArchive().getAsType(type, archivePath, archiveFormat);
    }

    @Override
    public <X extends Archive<X>> Collection<X> getAsType(Class<X> type, Filter<ArchivePath> archivePathFilter,
        ArchiveFormat archiveFormat) {
        return getArchive().getAsType(type, archivePathFilter, archiveFormat);
    }

    @Override
    public boolean contains(ArchivePath archivePath) throws IllegalArgumentException {
        return getArchive().contains(archivePath);
    }

    @Override
    public boolean contains(String path) throws IllegalArgumentException {
        return getArchive().contains(path);
    }

    @Override
    public Node delete(ArchivePath archivePath) throws IllegalArgumentException {
        return getArchive().delete(archivePath);
    }

    @Override
    public Node delete(String path) throws IllegalArgumentException {
        return getArchive().delete(path);
    }

    @Override
    public Map<ArchivePath, Node> getContent() {
        return getArchive().getContent();
    }

    @Override
    public Map<ArchivePath, Node> getContent(Filter<ArchivePath> archivePathFilter) {
        return getArchive().getContent(archivePathFilter);
    }

    @Override
    public AndroidArchive add(Archive<?> archive, ArchivePath archivePath, Class<? extends StreamExporter> exporter)
        throws IllegalArgumentException {
        getArchive().add(archive, archivePath, exporter);
        return this;
    }

    @Override
    public AndroidArchive add(Archive<?> archive, String path, Class<? extends StreamExporter> exporter)
        throws IllegalArgumentException {
        getArchive().add(archive, path, exporter);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive) throws IllegalArgumentException {
        getArchive().merge(archive);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive, Filter<ArchivePath> archivePathFilter) throws IllegalArgumentException {
        getArchive().merge(archive, archivePathFilter);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive, ArchivePath archivePath) throws IllegalArgumentException {
        getArchive().merge(archive, archivePath);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive, String path) throws IllegalArgumentException {
        getArchive().merge(archive, path);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive, ArchivePath archivePath, Filter<ArchivePath> archivePathFilter)
        throws IllegalArgumentException {
        getArchive().merge(archive, archivePath, archivePathFilter);
        return this;
    }

    @Override
    public AndroidArchive merge(Archive<?> archive, String path, Filter<ArchivePath> archivePathFilter)
        throws IllegalArgumentException {
        getArchive().merge(archive, path, archivePathFilter);
        return this;
    }

    @Override
    public AndroidArchive move(ArchivePath source, ArchivePath target) throws IllegalArgumentException,
        IllegalArchivePathException {
        getArchive().move(source, target);
        return this;
    }

    @Override
    public AndroidArchive move(String source, String target) throws IllegalArgumentException, IllegalArchivePathException {
        getArchive().move(source, target);
        return this;
    }

    @Override
    public String toString(boolean b) {
        return getArchive().toString();
    }

    @Override
    public String toString(Formatter formatter) throws IllegalArgumentException {
        return getArchive().toString(formatter);
    }

    @Override
    public void writeTo(OutputStream outputStream, Formatter formatter) throws IllegalArgumentException {
        getArchive().writeTo(outputStream, formatter);
    }

    @Override
    public Archive<AndroidArchive> shallowCopy() {
        final Archive<?> currentArchive = getArchive();
        final Configuration currentConfig = ((Configurable) currentArchive).getConfiguration();
        final Domain domain = ShrinkWrap.createDomain(currentConfig);
        final ArchiveFactory factory = domain.getArchiveFactory();
        final Archive<AndroidArchive> newArchive = factory.create(AndroidArchive.class, getName());
        final Map<ArchivePath, Node> contents = currentArchive.getContent();
        for (final ArchivePath path : contents.keySet()) {
            Asset asset = contents.get(path).getAsset();
            if (asset != null) {
                newArchive.add(asset, path);
            }
        }

        return newArchive;
    }

    private File fileFromResource(final String resourceName) throws IllegalArgumentException {
        final URL resourceUrl = AccessController.doPrivileged(GetTcclAction.INSTANCE).getResource(resourceName);
        Validate.notNull(resourceUrl, resourceName + " doesn't exist or can't be accessed");

        String resourcePath = AccessController.doPrivileged(GetTcclAction.INSTANCE).getResource(resourceName).getFile();
        try {
            resourcePath = URLDecoder.decode(resourcePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }

        return new File(resourcePath);
    }

    private enum GetTcclAction implements PrivilegedAction<ClassLoader> {
        INSTANCE;

        @Override
        public ClassLoader run() {
            return Thread.currentThread().getContextClassLoader();
        }
    }

    private Iterable<ClassLoader> getArchiveClassLoaders() {
        final Archive<?> archive = getArchive();
        final Iterable<ClassLoader> cls = ((Configurable) archive).getConfiguration().getClassLoaders();

        return cls;
    }

}
