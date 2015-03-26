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
import org.jclouds.openstack.designate.v2.domain.Blacklist;
import org.jclouds.openstack.designate.v2.options.CreateBlacklistOptions;
import org.jclouds.openstack.designate.v2.options.UpdateBlacklistOptions;
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
public interface BlacklistApi {
	

	/**
	 * @see BlacklistApi#list
	 * 
	 * @return
	 */
	@Named("Blacklists:list")
	@GET
	@Path("/blacklists")
	@SelectJson("blacklists")
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Blacklist> listBlacklists();

	/**
	 * @see BlacklistApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Blacklist:get")
	@GET
	@Path("/blacklists/{id}")
	@SelectJson("blacklist")
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Blacklist getBlacklist(@PathParam("id") String id);

	/**
	 * @see BlacklistApi#create
	 */
	@Named("Blacklist:create ")
	@POST
	@Path("/blacklists")
	@SelectJson("blacklist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(CreateBlacklistOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Blacklist createBlacklist(CreateBlacklistOptions ...options);
	
	/**
	 * @see BlacklistApi#update
	 */
	@Named("Blacklist:put")
	@PATCH
	@Path("/blacklists/{id}")
	@SelectJson("blacklist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(UpdateBlacklistOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Blacklist updateBlacklist(@PathParam("id") String id, UpdateBlacklistOptions ...options);

	/**
	 * @see BlacklistApi#delete
	 */
	@Named("Blacklist:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/blacklists/{id}")
	Boolean deleteBlacklist(@PathParam("id") String id);
	
}
