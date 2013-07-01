package org.jboss.shrinkwrap.impl.base.spec;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.spec.AndroidArchive;
import org.jboss.shrinkwrap.impl.base.AssignableBase;
import org.jboss.shrinkwrap.impl.base.container.ContainerBase;
import org.jboss.shrinkwrap.impl.base.path.BasicPath;


/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class AndroidArchiveImpl extends AssignableBase<Archive<?>> implements AndroidArchive {



    protected AndroidArchiveImpl(final Archive<?> delegate) {
        super(delegate);
    }




}
