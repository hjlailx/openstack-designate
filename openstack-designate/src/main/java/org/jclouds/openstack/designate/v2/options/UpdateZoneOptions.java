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
public class UpdateZoneOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromUpdateHealthmonitorOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();
		
		protected String name ;
		protected Integer ttl;
		protected String email ;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T ttl(Integer ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public T email(String email) {
			this.email = email;
			return self();
		}
		
		public UpdateZoneOptions build() {
			return new UpdateZoneOptions(name , ttl , email);
		}

		public T fromUpdateHealthmonitorOptions(UpdateZoneOptions options) {
			return this.name(options.getName()).ttl(options.getTtl()).email(options.getEmail());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateZoneRequest {
		protected String name ;
		protected Integer ttl;
		protected String email ;
	}

	private final String name ;
	private final Integer ttl;
	private final String email ;

	protected UpdateZoneOptions() {
		this.name = null ;
		this.ttl = null ;
		this.email = null ;
	}

	public UpdateZoneOptions(String name, Integer ttl, String email) {
		this.name = name ;
		this.ttl = ttl ;
		this.email = email ;
	}

	public String getName() {
		return name;
	}

	public Integer getTtl() {
		return ttl;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateZoneRequest updateZoneRequest = new UpdateZoneRequest();

		if (this.name != null)
			updateZoneRequest.name = this.name ;
		if (this.ttl != null)
			updateZoneRequest.ttl = this.ttl ;
		if (this.email != null)
			updateZoneRequest.email = this.email ;

		return bindToRequest(request,ImmutableMap.of("zone", updateZoneRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
