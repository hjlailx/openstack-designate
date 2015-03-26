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
import org.jclouds.openstack.designate.enumerate.RecordType;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

/**
 * @author hjl
 */
public class CreateRecordOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreateRecordOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String name ;
		protected RecordType type;
		protected String data ;
		protected Integer priority ;
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T type(RecordType type) {
			this.type = type;
			return self();
		}
		
		public T data(String data) {
			this.data = data;
			return self();
		}
		
		public T priority(Integer priority) {
			this.priority = priority;
			return self();
		}

		public CreateRecordOptions build() {
			return new CreateRecordOptions(name, type, data, priority);
		}

		public T fromCreateRecordOptions(CreateRecordOptions in) {
			return this.name(in.getName()).type(in.getType()).data(in.getData()).priority(in.getPriority());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateRecordRequest {
		
		protected String name ;
		protected RecordType type;
		protected String data ;
		protected Integer priority ;

	}

	private final String name ;
	private final RecordType type;
	private final String data ;
	private final Integer priority ;

	public CreateRecordOptions(String name, RecordType type, String data, Integer priority) {
		this.name = name ;
		this.type = type ;
		this.data = data ;
		this.priority = priority ;
	}

	public String getName() {
		return name;
	}

	public RecordType getType() {
		return type;
	}

	public String getData() {
		return data;
	}

	public Integer getPriority() {
		return priority;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateRecordRequest createRecordRequest = new CreateRecordRequest() ;

		if(this.name != null)
			createRecordRequest.name = this.name ;
		if(this.type != null)
			createRecordRequest.type = this.type ;
		if(this.data != null)
			createRecordRequest.data = this.data ;
		if(this.priority != null)
			createRecordRequest.priority = this.priority ;

		return bindToRequest(request, createRecordRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
