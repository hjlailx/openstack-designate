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

package org.jclouds.openstack.designate.v2.options;

import java.util.Map;

import javax.inject.Inject;

import org.jclouds.http.HttpRequest;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

import com.google.common.collect.ImmutableMap;

/**
 * @author hjl
 */
public class CreateAcceptTransferOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreateDomainOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String key ;
		protected String zoneTransferRequestId;
		
		public T key(String key) {
			this.key = key;
			return self();
		}
		
		public T zoneTransferRequestId(String zoneTransferRequestId) {
			this.zoneTransferRequestId = zoneTransferRequestId;
			return self();
		}

		public CreateAcceptTransferOptions build() {
			return new CreateAcceptTransferOptions(key, zoneTransferRequestId);
		}

		public T fromCreateDomainOptions(CreateAcceptTransferOptions in) {
			return this.key(in.getKey()).zoneTransferRequestId(in.getZone_transfer_request_id());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateAcceptTransferRequest {
		
		protected String key ;
		protected String zone_transfer_request_id;

	}

	private final String key ;
	private final String zone_transfer_request_id;

	public CreateAcceptTransferOptions(String key, String zone_transfer_request_id) {
		this.key = key;
		this.zone_transfer_request_id = zone_transfer_request_id ;
	}

	public String getKey() {
		return key;
	}

	public String getZone_transfer_request_id() {
		return zone_transfer_request_id;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateAcceptTransferRequest createAcceptTransferRequest = new CreateAcceptTransferRequest() ;

		if(this.key != null)
			createAcceptTransferRequest.key = this.key ;
		if(this.zone_transfer_request_id != null)
			createAcceptTransferRequest.zone_transfer_request_id = this.zone_transfer_request_id ;

		return bindToRequest(request, ImmutableMap.of("transfer_accept", createAcceptTransferRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
