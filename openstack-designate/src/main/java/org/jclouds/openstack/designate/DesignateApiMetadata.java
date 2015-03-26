/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.openstack.designate;

import static org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties.CREDENTIAL_TYPE;
import static org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties.SERVICE_TYPE;

import java.net.URI;
import java.util.Properties;

import org.jclouds.apis.ApiMetadata;
import org.jclouds.http.okhttp.config.OkHttpCommandExecutorServiceModule;
import org.jclouds.openstack.designate.config.DesignateHttpApiModule;
import org.jclouds.openstack.designate.config.DesignateTypeAdapters;
import org.jclouds.openstack.keystone.v2_0.config.AuthenticationApiModule;
import org.jclouds.openstack.keystone.v2_0.config.CredentialTypes;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneAuthenticationModule;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneAuthenticationModule.ZoneModule;
import org.jclouds.openstack.v2_0.ServiceType;
import org.jclouds.rest.internal.BaseHttpApiMetadata;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

/**
 * Implementation of {@link org.jclouds.apis.ApiMetadata} for Murano 1.0 API
 * 
 * @author hjl
 *
 */
public class DesignateApiMetadata extends BaseHttpApiMetadata<DesignateApi> {
	
	@Override
	public Builder toBuilder() {
		return new Builder().fromApiMetadata(this);
	}
	
	public DesignateApiMetadata() {
		super(new Builder()) ;
	}

	protected DesignateApiMetadata(Builder builder) {
		super(builder);
	}

	public static Properties defaultProperties() {
		Properties properties = BaseHttpApiMetadata.defaultProperties();
		properties.setProperty(SERVICE_TYPE, ServiceType.DNSSERVER);
		properties.setProperty(CREDENTIAL_TYPE,
				CredentialTypes.PASSWORD_CREDENTIALS);

		return properties;
	}

	public static class Builder extends BaseHttpApiMetadata.Builder<DesignateApi, Builder> {

		protected Builder() {
			super(DesignateApi.class);
			id("openstack-designate")
			.name("OpenStack designate icehouse API")
			.identityName("${tenantName}:${userName} or ${userName}, if your keystone supports a default tenant")
			.credentialName("${password}")
			.documentation(URI.create("https://designate.readthedocs.org/en/stable-juno/specification/index.html"))
			.version("1.0")
			.endpointName("Keystone base url ending in /v2.0/")
			.defaultEndpoint("http://localhost:5000/v2.0/")
			.defaultProperties(DesignateApiMetadata.defaultProperties())
			.defaultModules(ImmutableSet
					.<Class<? extends Module>> builder()
					.add(AuthenticationApiModule.class)
					.add(KeystoneAuthenticationModule.class)
					.add(OkHttpCommandExecutorServiceModule.class)
					.add(ZoneModule.class)
					.add(DesignateTypeAdapters.class)
					.add(DesignateHttpApiModule.class).build());
		}

		@Override
		public DesignateApiMetadata build() {
			return new DesignateApiMetadata(this);
		}
		
	    @Override
	    public Builder fromApiMetadata(ApiMetadata in) {
	    	super.fromApiMetadata(in);
	    	return this;
	    }

		@Override
		protected Builder self() {
			return this;
		}
	}

}
