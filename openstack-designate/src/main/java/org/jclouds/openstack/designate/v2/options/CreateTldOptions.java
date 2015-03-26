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
public class CreateTldOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreateZoneOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String name ;
		protected String description ;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T description(String description) {
			this.description = description;
			return self();
		}

		public CreateTldOptions build() {
			return new CreateTldOptions(name, description);
		}

		public T fromCreateZoneOptions(CreateTldOptions in) {
			return this.name(in.getName()).description(in.getDescription());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateTldRequest {
		
		protected String name ;
		protected String description ;

	}

	private final String name ;
	private final String description ;

	public CreateTldOptions(String name, String description) {
		this.name = name;
		this.description = description ;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateTldRequest createTldRequest = new CreateTldRequest() ;

		if(this.name != null)
			createTldRequest.name = this.name ;
		if(this.description != null)
			createTldRequest.description = this.description ;

		return bindToRequest(request, ImmutableMap.of("tld", createTldRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
