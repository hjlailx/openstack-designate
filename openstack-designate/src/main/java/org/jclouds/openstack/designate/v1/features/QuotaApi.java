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
package org.jclouds.openstack.designate.v1.features;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.designate.v1.domain.Quota;
import org.jclouds.openstack.designate.v1.domain.Record;
import org.jclouds.openstack.designate.v1.options.UpdateQuotaOptions;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.RequestFilters;

/**
 * Provides synchronous access to DesignateService operations on the
 * OpenStack designate API.
 * <p/>
 *
 * @author hjl
 */
//@Path("/v1")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
public interface QuotaApi {
	

	/**
	 * @see QuotaApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Quota:get")
	@GET
	@Path("/quotas/{tenantId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Quota getQuota(@PathParam("tenantId") String tenantId);

	/**
	 * Record upate
	 * @param domainId
	 * @param recordId
	 * @param name
	 * @param type
	 * @param data
	 * @return
	 */
	@Named("Quota:put")
	@PUT
	@Path("/quotas/{tenantId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(UpdateQuotaOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Record updateRecord(@PathParam("tenantId") String tenantId , UpdateQuotaOptions ...options);

	/**
	 * @see QuotaApi#Reset
	 */
	@Named("Record:Reset")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/quotas/{tenantId}")
	Boolean deleteQuota(@PathParam("tenantId") String tenantId);

}
