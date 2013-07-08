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
public interface AndroidArchive extends Archive<AndroidArchive>, ResourceContainer<AndroidArchive>, ClassContainer<AndroidArchive> {

    public AndroidArchive addAsAndroidManifest(String resourceName);

    public AndroidArchive addAsAndroidManifest(File resource);

    public AndroidArchive addAsAndroidManifest(URL resource);

    public AndroidArchive addAsAndroidManifest(Asset resource);

    /*public AndroidArchive addAsResource(String resourceName, String target);

    public AndroidArchive addAsResource(File resource, String target);

    public AndroidArchive addAsResource(URL resource, String target);

    public AndroidArchive addAsResource(Asset resource, String target);

    public AndroidArchive addAsResource(String resourceName, ArchivePath target);

    public AndroidArchive addAsResource(File resource, ArchivePath target);

    public AndroidArchive addAsResource(URL resource, ArchivePath target);

    public AndroidArchive addAsResource(Asset resource, ArchivePath target);
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
