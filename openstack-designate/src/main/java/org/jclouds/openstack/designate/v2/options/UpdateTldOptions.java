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
public class UpdateTldOptions implements MapBinder {

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
		protected String email ;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T email(String email) {
			this.email = email;
			return self();
		}
		
		public UpdateTldOptions build() {
			return new UpdateTldOptions(name, email);
		}

		public T fromUpdateHealthmonitorOptions(UpdateTldOptions options) {
			return this.name(options.getName()).email(options.getEmail());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateTldRequest {
		protected String name ;
		protected String email ;
	}

	private final String name ;
	private final String email ;

	protected UpdateTldOptions() {
		this.name = null ;
		this.email = null ;
	}

	public UpdateTldOptions(String name, String email) {
		this.name = name ;
		this.email = email ;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateTldRequest updateTldRequest = new UpdateTldRequest();

		if (this.name != null)
			updateTldRequest.name = this.name ;
		if (this.email != null)
			updateTldRequest.email = this.email ;

		return bindToRequest(request,ImmutableMap.of("tld", updateTldRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
