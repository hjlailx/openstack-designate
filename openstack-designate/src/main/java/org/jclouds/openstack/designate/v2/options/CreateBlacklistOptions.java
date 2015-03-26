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
public class CreateBlacklistOptions implements MapBinder {

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

		protected String pattern ;
		protected String description ;
		
		public T pattern(String pattern) {
			this.pattern = pattern;
			return self();
		}
		
		public T description(String description) {
			this.description = description;
			return self();
		}

		public CreateBlacklistOptions build() {
			return new CreateBlacklistOptions(pattern, description);
		}

		public T fromCreateZoneOptions(CreateBlacklistOptions in) {
			return this.pattern(in.getPattern()).description(in.getDescription());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateBlacklistRequest {
		
		protected String pattern ;
		protected String description ;

	}

	private final String pattern ;
	private final String description ;

	public CreateBlacklistOptions(String pattern, String description) {
		this.pattern = pattern ;
		this.description = description ;
	}

	public String getPattern() {
		return pattern;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateBlacklistRequest createBlacklistRequest = new CreateBlacklistRequest() ;

		if(this.pattern != null)
			createBlacklistRequest.pattern = this.pattern ;
		if(this.description != null)
			createBlacklistRequest.description = this.description ;

		return bindToRequest(request, ImmutableMap.of("blacklist", createBlacklistRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
