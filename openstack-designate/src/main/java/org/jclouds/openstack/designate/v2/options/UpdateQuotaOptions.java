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
		
		protected Integer zones ;
		protected Integer recordset_records;
		protected Integer zone_records ;
		protected Integer zone_recordsets ;
		
		public T zones(Integer zones) {
			this.zones = zones;
			return self();
		}
		
		public T recordset_records(Integer recordset_records) {
			this.recordset_records = recordset_records;
			return self();
		}
		
		public T zone_records(Integer zone_records) {
			this.zone_records = zone_records;
			return self();
		}
		
		public T zone_recordsets(Integer zone_recordsets) {
			this.zone_recordsets = zone_recordsets;
			return self();
		}
		
		public UpdateQuotaOptions build() {
			return new UpdateQuotaOptions(zones , recordset_records , zone_records, zone_recordsets);
		}

		public T fromUpdateHealthmonitorOptions(UpdateQuotaOptions options) {
			return this.zones(options.getZones()).recordset_records(options.getRecordset_records())
					.zone_records(options.getZone_records()).zone_recordsets(options.getZone_recordsets());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdateQuotaRequest {
		protected Integer zones  ;
		protected Integer recordset_records;
		protected Integer zone_records ;
		protected Integer zone_recordsets ; 
	}

	private final Integer zones ;
	private final Integer recordset_records;
	private final Integer zone_records ;
	private final Integer zone_recordsets ;

	protected UpdateQuotaOptions() {
		this.zones = null ;
		this.recordset_records = null ;
		this.zone_records = null ;
		this.zone_recordsets = null ;
	}

	public UpdateQuotaOptions(Integer zones, Integer recordset_records, Integer zone_records, Integer zone_recordsets) {
		this.zones = zones ;
		this.recordset_records = recordset_records ;
		this.zone_records = zone_records ;
		this.zone_recordsets = zone_recordsets ;
	}

	public Integer getZones() {
		return zones;
	}

	public Integer getRecordset_records() {
		return recordset_records;
	}

	public Integer getZone_records() {
		return zone_records;
	}

	public Integer getZone_recordsets() {
		return zone_recordsets;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdateQuotaRequest updateQuotaRequest = new UpdateQuotaRequest();

		if (this.zones != null)
			updateQuotaRequest.zones = this.zones ;
		if (this.recordset_records != null)
			updateQuotaRequest.recordset_records = this.recordset_records ;
		if (this.recordset_records != null)
			updateQuotaRequest.recordset_records = this.recordset_records ;
		if (this.zone_recordsets != null)
			updateQuotaRequest.zone_recordsets = this.zone_recordsets ;

		return bindToRequest(request,updateQuotaRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
