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
public class CreateZoneTransferOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreateZoneTransferOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String targetProjectId ;
		protected String description ;
		
		public T targetProjectId(String targetProjectId) {
			this.targetProjectId = targetProjectId;
			return self();
		}
		
		public T description(String description) {
			this.description = description;
			return self();
		}

		public CreateZoneTransferOptions build() {
			return new CreateZoneTransferOptions(targetProjectId, description);
		}

		public T fromCreateZoneTransferOptions(CreateZoneTransferOptions in) {
			return this.targetProjectId(in.getTarget_project_id()).description(in.getDescription());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateZoneTransferRequest {
		
		protected String target_project_id ;
		protected String description ;

	}

	private final String target_project_id ;
	private final String description ;

	public CreateZoneTransferOptions(String target_project_id, String description) {
		this.target_project_id = target_project_id;
		this.description = description ;
	}

	public String getTarget_project_id() {
		return target_project_id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateZoneTransferRequest createZoneTransferRequest = new CreateZoneTransferRequest() ;

		if(this.target_project_id != null)
			createZoneTransferRequest.target_project_id = this.target_project_id ;
		if(this.description != null)
			createZoneTransferRequest.description = this.description ;

		return bindToRequest(request, ImmutableMap.of("transfer_request", createZoneTransferRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
