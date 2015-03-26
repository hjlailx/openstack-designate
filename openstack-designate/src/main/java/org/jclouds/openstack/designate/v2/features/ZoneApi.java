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
import org.jclouds.openstack.designate.v2.domain.TransferAccept;
import org.jclouds.openstack.designate.v2.domain.TransferRequest;
import org.jclouds.openstack.designate.v2.domain.Zone;
import org.jclouds.openstack.designate.v2.options.CreateAcceptTransferOptions;
import org.jclouds.openstack.designate.v2.options.CreateZoneOptions;
import org.jclouds.openstack.designate.v2.options.CreateZoneTransferOptions;
import org.jclouds.openstack.designate.v2.options.UpdateZoneOptions;
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
public interface ZoneApi {
	

	/**
	 * @see ZoneApi#list
	 * 
	 * @return
	 */
	@Named("Zones:list")
	@GET
	@Path("/zones")
	@SelectJson("zones")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Zone> listZones();

	/**
	 * @see ZoneApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Zone:get")
	@GET
	@Path("/zones/{id}")
	@SelectJson("zone")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Zone getZone(@PathParam("id") String id);

	/**
	 * @see ZoneApi#create
	 */
	@Named("zones:create ")
	@POST
	@Path("/zones")
	@SelectJson("zone")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(CreateZoneOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Zone createZone(CreateZoneOptions ...options);
	
	/**
	 * @see ZoneApi#update
	 */
	@Named("Zone:put")
	@PATCH
	@Path("/zones/{id}")
	@SelectJson("zone")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(UpdateZoneOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Zone updateZone(@PathParam("id") String id, UpdateZoneOptions ...options);

	/**
	 * @see ZoneApi#delete
	 */
	@Named("zone:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/zones/{id}")
	Boolean deleteZone(@PathParam("id") String id);
	
	/**
	 * @see ZoneApi#Abandon
	 */
	@Named("zone:Abandon")
	@POST
	@Fallback(FalseOnNotFoundOr404.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/zones/{id}/tasks/abandon")
	Boolean abandonZone(@PathParam("id") String zoneId);
	
	/**
	 * @see ZoneApi#Transfer
	 */
	@Named("zone:Transfer")
	@POST
	@Fallback(FalseOnNotFoundOr404.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@SelectJson("transfer_request")
	@MapBinder(CreateZoneTransferOptions.class)
	@Path("/zones/{id}/tasks/transfer_requests")
	TransferRequest transferRequestsZone(@PathParam("id") String zoneId, CreateZoneTransferOptions ...options);
	
	/**
	 * @see ZoneApi#List
	 */
	@Named("Transfer:List")
	@GET
	@Fallback(FalseOnNotFoundOr404.class)
	@Produces(MediaType.APPLICATION_JSON)
	@SelectJson("transfer_requests")
	@Path("/zones/tasks/transfer_requests")
	TransferRequest listTransferRequestsZone();
	
	/**
	 * @see ZoneApi#View
	 */
	@Named("Transfer:View")
	@GET
	@Fallback(FalseOnNotFoundOr404.class)
	@Produces(MediaType.APPLICATION_JSON)
	@SelectJson("transfer_request")
	@Path("/zones/tasks/transfer_requests/{id}")
	TransferRequest getTransferRequestsZone(@PathParam("id") String transferId);
	
	/**
	 * @see ZoneApi#Accept a Transfer
	 */
	@Named("Transfer:Accept")
	@POST
	@Fallback(FalseOnNotFoundOr404.class)
	@Produces(MediaType.APPLICATION_JSON)
	@SelectJson("transfer_request")
	@MapBinder(CreateAcceptTransferOptions.class)
	@Path("/zones/tasks/transfer_accept")
	TransferAccept acceptTransferRequestsZone(@PathParam("id") String transferId, CreateAcceptTransferOptions ...options);
	
	
//	/**
//	 * @see ZoneApi#import zone
//	 */
//	@Named("Zone:Import")
//	@POST
//	@Fallback(FalseOnNotFoundOr404.class)
//	@Produces(MediaType.APPLICATION_JSON)
//	@SelectJson("zone")
//	@Path("/zones")
//	Zone importZone();
//	
//	/**
//	 * @see ZoneApi#import Export
//	 */
//	@Named("Zone:Export")
//	@POST
//	@Fallback(FalseOnNotFoundOr404.class)
//	@Produces(MediaType.APPLICATION_JSON)
//	@SelectJson("transfer_request")
//	@Path("/zones/{id}")
//	String exportZone(@PathParam("id") String zoneId);
	

}
