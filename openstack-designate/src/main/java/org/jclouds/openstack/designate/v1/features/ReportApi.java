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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.designate.v1.domain.Report;
import org.jclouds.openstack.designate.v1.domain.Tenant;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.collect.FluentIterable;

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
public interface ReportApi {
	
	
	/**
	 * Get all tenants
	 * @return
	 */
	@Named("Get:tenants")
	@GET
	@Path("/reports/tenants")
	@SelectJson("tenants")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Tenant> listTenants();
	

	/**
	 * @see ReportApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Report:tenant")
	@GET
	@Path("/reports/tenants/{tenantId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Tenant getTenant(@PathParam("tenantId") String tenantId);

	/**
	 * Report resource counts
	 */
	@Named("Report:count")
	@GET
	@Path("/reports/counts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Report reportCount();
	
	/**
	 * Report tenant counts
	 */
	@Named("Report:countTenant")
	@GET
	@Path("/reports/counts/tenants")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Report reportCountTenant();
	
	/**
	 * Report domain counts
	 */
	@Named("Report:countDomain")
	@GET
	@Path("/reports/counts/domains")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Report reportCountDomain();
	
	/**
	 * Report record counts
	 */
	@Named("Report:record")
	@GET
	@Path("/reports/counts/records")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Report reportCountRecord();

}
