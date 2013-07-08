package org.jboss.shrinkwrap.android.api.spec;

import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.android.api.spec.node.Manifest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class AndroidManifest extends Manifest implements Asset {

    public String toXmlString() {
        return super.toXmlString("");
    }

    @Override
    public InputStream openStream() {
        return new ByteArrayInputStream(toXmlString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String toString() {
        return toXmlString();
    }

    public interface Builder {

        // TODO do we need builder?

    }







}
