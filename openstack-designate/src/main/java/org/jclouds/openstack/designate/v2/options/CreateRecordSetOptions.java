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
import org.jclouds.openstack.designate.enumerate.RecordType;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

import com.google.common.collect.ImmutableMap;

/**
 * @author hjl
 */
public class CreateRecordSetOptions implements MapBinder {

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
		protected Integer ttl;
		protected RecordType type ;
		protected String description ;
		protected Set<String> records ;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T ttl(Integer ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public T type(RecordType type) {
			this.type = type;
			return self();
		}
		
		public T description(String description) {
			this.description = description;
			return self();
		}
		
		public T records(Set<String> records) {
			this.records = records;
			return self();
		}

		public CreateRecordSetOptions build() {
			return new CreateRecordSetOptions(name, ttl, type, description, records);
		}

		public T fromCreateZoneOptions(CreateRecordSetOptions in) {
			return this.name(in.getName()).ttl(in.getTtl()).type(in.getType()).description(in.getDescription()).records(in.getRecords());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateRecordSetRequest {
		
		protected String name ;
		protected Integer ttl;
		protected RecordType type;
		protected String description ;
		protected Set<String> records ;

	}

	private final String name ;
	private final Integer ttl;
	private final RecordType type ;
	private final String description ;
	protected Set<String> records ;

	public CreateRecordSetOptions(String name, Integer ttl, RecordType type, String description, Set<String> records) {
		this.name = name ;
		this.ttl = ttl;
		this.type = type ;
		this.description = description ;
		this.records = records ;
	}

	public String getName() {
		return name;
	}

	public Set<String> getRecords() {
		return records;
	}

	public void setRecords(Set<String> records) {
		this.records = records;
	}

	public RecordType getType() {
		return type;
	}

	public Integer getTtl() {
		return ttl;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateRecordSetRequest createRecordSetRequest = new CreateRecordSetRequest() ;

		if(this.ttl != null)
			createRecordSetRequest.ttl = this.ttl ;
		if(this.name != null)
			createRecordSetRequest.name = this.name ;
		if(this.type != null)
			createRecordSetRequest.type = this.type ;
		if(this.description != null)
			createRecordSetRequest.description = this.description ;
		if(this.records != null)
			createRecordSetRequest.records = this.records ;

		return bindToRequest(request, ImmutableMap.of("recordset", createRecordSetRequest));
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
