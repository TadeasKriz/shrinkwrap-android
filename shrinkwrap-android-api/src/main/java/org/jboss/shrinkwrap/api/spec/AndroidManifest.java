package org.jboss.shrinkwrap.api.spec;

import org.jboss.shrinkwrap.api.spec.node.*;

import java.util.List;

/**
 * @author <a href="mailto:tkriz@redhat.com">Tadeas Kriz</a>
 */
public class AndroidManifest extends Manifest {

    

    public interface Builder {

        public List<UsesPermission> getUsesPermissions();

        public Builder addUsesPermission(UsesPermission usesPermission);

        public List<Permission> getPermissions();

        public Builder permission(Permission permission);

        public List<PermissionTree> getPermissionTrees();

        public Builder addPermissionTree(PermissionTree permissionTree);

        public List<PermissionGroup> getPermissionGroups();

        public Builder addPermissionGroup(PermissionGroup permissionGroup);

        public List<Instrumentation> getInstrumentations();

        public Builder addInstrumentation(Instrumentation instrumentation);

        public UsesSdk getUsesSdk();

        public Builder setUsesSdk(UsesSdk usesSdk);

        public List<UsesConfiguration> getUsesConfigurations();

        public Builder addUsesConfiguration(UsesConfiguration usesConfiguration);

        public List<UsesFeature> getUsesFeatures();

        public Builder addUsesFeature(UsesFeature usesFeature);

        public SupportsScreens getSupportsScreens();

        public Builder setSupportScreens(SupportsScreens supportScreens);

        public CompatibleScreens getCompatibleScreens();

        public Builder setCompatibleScreens(CompatibleScreens compatibleScreens);

        public List<SupportsGlTexture> getSupportsGlTextures();

        public Builder addSupportsGlTexture(SupportsGlTexture supportsGlTexture);



        public Builder activity();

        public Builder activityAlias();

        public Builder service();

        public Builder receiver();

        public Builder provider();

        public Builder usesLibrary();

    }







}
