package com.xworkz.cmodule.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class AbstractAuditEntity implements Serializable {
    private String createdBy;
    private LocalDateTime createdDate = LocalDateTime.now();

    private String updatedBy;
    private LocalDateTime updatedDate;

}
