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
public class UpdateQuotaOptions implements MapBinder {

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
		
		protected Integer domains ;
		protected Integer domainRecords;
		protected Integer recordsetRecords ;
		protected Integer domainRecordsets ;
		
		public T domains(Integer domains) {
			this.domains = domains;
			return self();
		}
		
		public T domainRecords(Integer domainRecords) {
			this.domainRecords = domainRecords;
			return self();
		}
		
		public T recordsetRecords(Integer recordsetRecords) {
			this.recordsetRecords = recordsetRecords;
			return self();
		}
		
		public T domainRecordsets(Integer domainRecordsets) {
			this.domainRecordsets = domainRecordsets;
			return self();
		}
		
		public UpdateQuotaOptions build() {
			return new UpdateQuotaOptions(domains , domainRecords , recordsetRecords, domainRecordsets);
		}

		public T fromUpdateHealthmonitorOptions(UpdateQuotaOptions options) {
			return this.domains(options.getDomains()).domainRecords(options.getDomain_records())
					.recordsetRecords(options.getRecordset_records()).domainRecordsets(options.getDomain_recordsets());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateQuotaRequest {
		protected Integer domains  ;
		protected Integer recordset_records;
		protected Integer domain_records ;
		protected Integer domain_recordsets ; 
	}

	private final Integer domains ;
	private final Integer recordset_records;
	private final Integer domain_records ;
	private final Integer domain_recordsets ;

	protected UpdateQuotaOptions() {
		this.domains = null ;
		this.recordset_records = null ;
		this.domain_records = null ;
		this.domain_recordsets = null ;
	}

	public UpdateQuotaOptions(Integer domains, Integer recordsetRecords, Integer domainRecords, Integer domainRecordsets) {
		this.domains = domains ;
		this.recordset_records = recordsetRecords ;
		this.domain_records = domainRecords ;
		this.domain_recordsets = domainRecordsets ;
	}

	public Integer getDomains() {
		return domains;
	}

	public Integer getRecordset_records() {
		return recordset_records;
	}

	public Integer getDomain_records() {
		return domain_records;
	}

	public Integer getDomain_recordsets() {
		return domain_recordsets;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateQuotaRequest updateQuotaRequest = new UpdateQuotaRequest();

		if (this.domains != null)
			updateQuotaRequest.domains = this.domains ;
		if (this.recordset_records != null)
			updateQuotaRequest.recordset_records = this.recordset_records ;
		if (this.domain_records != null)
			updateQuotaRequest.domain_records = this.domain_records ;
		if (this.domain_recordsets != null)
			updateQuotaRequest.domain_recordsets = this.domain_recordsets ;

		return bindToRequest(request,updateQuotaRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
