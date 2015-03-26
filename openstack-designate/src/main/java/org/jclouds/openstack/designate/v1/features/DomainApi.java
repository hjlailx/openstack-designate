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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.designate.v1.domain.Domain;
import org.jclouds.openstack.designate.v1.domain.Server;
import org.jclouds.openstack.designate.v1.options.CreateDomainOptions;
import org.jclouds.openstack.designate.v1.options.UpdateDomainOptions;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
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
public interface DomainApi {
	
	/**
	 * @see DomainApi#list
	 * 
	 * @return
	 */
	@Named("domains:list")
	@GET
	@Path("/domains")
	@SelectJson("domains")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Domain> listDomains();

	/**
	 * @see DomainApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("domains:get")
	@GET
	@Path("/domains/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Domain getDomain(@PathParam("id") String id);

	/**
	 * @see DomainApi#create
	 */
	@Named("domains:create ")
	@POST
	@Path("/domains")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(CreateDomainOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Domain createDomain(CreateDomainOptions ...options);
	
	@Named("domains:put")
	@PUT
	@Path("/domains/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(UpdateDomainOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Domain updateDomain(@PathParam("id") String id, UpdateDomainOptions ...options);

	/**
	 * @see DomainApi#delete
	 */
	@Named("domains:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/domains/{id}")
	Boolean deleteDeployment(@PathParam("id") String id);
	
	
	/**
	 * @see DomainApi#getServers Hosting a Domain
	 * 
	 * @param id
	 * @return
	 */
	@Named("domains:getServers Hosting a Domain")
	@GET
	@Path("/domains/{id}/servers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	FluentIterable<? extends Server> getDomainServers(@PathParam("id") String id);
}
