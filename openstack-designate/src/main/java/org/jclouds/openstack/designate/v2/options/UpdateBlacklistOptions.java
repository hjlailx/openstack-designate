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
public class UpdateBlacklistOptions implements MapBinder {

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
		
		protected String description ;
		protected String pattern;
		
		public T description(String description) {
			this.description = description;
			return self();
		}
		
		public T pattern(String pattern) {
			this.pattern = pattern;
			return self();
		}
		
		public UpdateBlacklistOptions build() {
			return new UpdateBlacklistOptions(description, pattern);
		}

		public T fromUpdateHealthmonitorOptions(UpdateBlacklistOptions options) {
			return this.description(options.getDescription()).pattern(options.getPattern());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateBlacklistRequest {
		protected String description ;
		protected String pattern ;
	}

	private final String description ;
	private final String pattern;

	protected UpdateBlacklistOptions() {
		this.description = null ;
		this.pattern = null ;
	}

	public UpdateBlacklistOptions(String description, String pattern) {
		this.description = description ;
		this.pattern = pattern ;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPattern() {
		return pattern;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateBlacklistRequest updateBlacklistRequest = new UpdateBlacklistRequest();

		if (this.description != null)
			updateBlacklistRequest.description = this.description ;
		if (this.pattern != null)
			updateBlacklistRequest.pattern = this.pattern ;

		return bindToRequest(request,ImmutableMap.of("blacklist", updateBlacklistRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
