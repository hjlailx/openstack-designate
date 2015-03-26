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

import java.io.Closeable;
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.location.Zone;
import org.jclouds.location.functions.ZoneToEndpoint;
import org.jclouds.openstack.designate.v1.features.DiagnosticsApi;
import org.jclouds.openstack.designate.v1.features.DnsServerApi;
import org.jclouds.openstack.designate.v1.features.DomainApi;
import org.jclouds.openstack.designate.v1.features.QuotaApi;
import org.jclouds.openstack.designate.v1.features.RecordApi;
import org.jclouds.openstack.designate.v1.features.ReportApi;
import org.jclouds.openstack.designate.v1.features.SynchronizeApi;
import org.jclouds.openstack.designate.v2.features.BlacklistApi;
import org.jclouds.openstack.designate.v2.features.CollectionApi;
import org.jclouds.openstack.designate.v2.features.TldApi;
import org.jclouds.openstack.designate.v2.features.ZoneApi;
import org.jclouds.rest.annotations.Delegate;
import org.jclouds.rest.annotations.EndpointParam;

import com.google.inject.Provides;

/**
 * Murano is a robust, web-scale message queuing service to support the
 * distributed nature of large web applications.
 *
 * @author hjl
 */
public interface DesignateApi extends Closeable {

	/**
	 * @return The Zone codes configured
	 */
	@Provides
	@Zone
	Set<String> getConfiguredZones();

	// v1
	@Delegate
	DiagnosticsApi getV1DiagnosticsApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	DnsServerApi getV1DnsServerApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	DomainApi getV1DomainApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	QuotaApi getV1QuotaApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	RecordApi getV1RecordApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	ReportApi getV1ReportApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	SynchronizeApi getV1SynchronizeApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	// v2
	@Delegate
	BlacklistApi getV2BlacklistApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	CollectionApi getV2CollectionApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	org.jclouds.openstack.designate.v2.features.QuotaApi getV2QuotaApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	org.jclouds.openstack.designate.v2.features.RecordApi getV2RecordApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	TldApi getV2TldApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	ZoneApi getV2ZoneApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
}
