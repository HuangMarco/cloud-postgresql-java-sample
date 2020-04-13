package com.sap.cp.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "t_example_model" )
@EntityListeners( AuditingEntityListener.class )
//@Multitenant
//@TenantDiscriminatorColumn( name = "tenant_id", contextProperty = "eclipselink.tenant-id", length = 36 )
@AllArgsConstructor
@NoArgsConstructor
public @Data class ExampleModelEntity {
	@Id
	@Column( name = "entity_key" )
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String key;
	
	@Column( name = "entity_name" )
	private String groupName;
}
