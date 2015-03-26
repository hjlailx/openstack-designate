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

package org.jclouds.openstack.designate.v1.options;

import java.util.Map;

import javax.inject.Inject;

import org.jclouds.http.HttpRequest;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

/**
 * @author hjl
 */
public class CreateDomainOptions implements MapBinder {

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

		public CreateDomainOptions build() {
			return new CreateDomainOptions(name, ttl, email);
		}

		public T fromCreateDomainOptions(CreateDomainOptions in) {
			return this.name(in.getName()).ttl(in.getTtl()).email(in.getEmail());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateDomainRequest {
		
		protected String name ;
		protected Integer ttl;
		protected String email;

	}

	private final String name ;
	private final Integer ttl;
	private final String email ;

	public CreateDomainOptions(String name, Integer ttl, String email) {
		this.name = name;
		this.ttl = ttl;
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
		CreateDomainRequest createDomainRequest = new CreateDomainRequest() ;

		if(this.ttl != null)
			createDomainRequest.ttl = this.ttl ;
		if(this.name != null)
			createDomainRequest.name = this.name ;
		if(this.email != null)
			createDomainRequest.email = this.email ;

		return bindToRequest(request, createDomainRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
