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
import java.util.Set;

import javax.inject.Inject;

import org.jclouds.http.HttpRequest;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

import com.google.common.collect.ImmutableMap;

/**
 * @author hjl
 */
public class UpdateRecordSetOptions implements MapBinder {

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
		protected Integer ttl;
		protected Set<String> records ;
		
		public T description(String description) {
			this.description = description;
			return self();
		}
		
		public T ttl(Integer ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public T records(Set<String> records) {
			this.records = records;
			return self();
		}
		
		public UpdateRecordSetOptions build() {
			return new UpdateRecordSetOptions(description , ttl , records);
		}

		public T fromUpdateHealthmonitorOptions(UpdateRecordSetOptions options) {
			return this.description(options.getDescription()).ttl(options.getTtl()).records(options.getRecords());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateRecordSetRequest {
		protected String description ;
		protected Integer ttl;
		protected Set<String> records ;
	}

	private final String description ;
	private final Integer ttl;
	private final Set<String> records ;

	protected UpdateRecordSetOptions() {
		this.description = null ;
		this.ttl = null ;
		this.records = null ;
	}

	public UpdateRecordSetOptions(String description, Integer ttl, Set<String> records) {
		this.description = description ;
		this.ttl = ttl ;
		this.records = records ;
	}

	public String getDescription() {
		return description;
	}

	public Integer getTtl() {
		return ttl;
	}

	public Set<String> getRecords() {
		return records;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateRecordSetRequest updateRecordSetRequest = new UpdateRecordSetRequest();

		if (this.description != null)
			updateRecordSetRequest.description = this.description ;
		if (this.ttl != null)
			updateRecordSetRequest.ttl = this.ttl ;
		if (this.records != null)
			updateRecordSetRequest.records = this.records ;

		return bindToRequest(request,ImmutableMap.of("recordset", updateRecordSetRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
