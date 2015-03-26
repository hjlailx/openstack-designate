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
package org.jclouds.openstack.designate.v2.features;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.designate.v2.domain.Tld;
import org.jclouds.openstack.designate.v2.options.CreateTldOptions;
import org.jclouds.openstack.designate.v2.options.UpdateTldOptions;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.PATCH;
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
@Path("/v2")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
public interface TldApi {
	

	/**
	 * @see TldApi#list
	 * 
	 * @return
	 */
	@Named("Tlds:list")
	@GET
	@Path("/tlds")
	@SelectJson("tlds")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Tld> listTlds();

	/**
	 * @see TldApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Tlds:get")
	@GET
	@Path("/tlds/{id}")
	@SelectJson("tld")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Tld getTld(@PathParam("id") String tldsId);

	/**
	 * @see TldApi#create
	 */
	@Named("Tlds :create ")
	@POST
	@Path("/tlds")
	@SelectJson("tld")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(CreateTldOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Tld createTld(CreateTldOptions ...options);
	
	/**
	 * @see TldApi#update
	 */
	@Named("Tld:put")
	@PATCH
	@Path("/tlds/{id}")
	@SelectJson("tld")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(UpdateTldOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Tld updateTld(@PathParam("id") String tldId, UpdateTldOptions ...options);

	/**
	 * @see TldApi#delete
	 */
	@Named("Tld:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/tlds/{id}")
	Boolean deleteTld(@PathParam("id") String tldId);
	
}
