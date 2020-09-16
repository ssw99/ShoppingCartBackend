package dev.serhats.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseModel implements Serializable {
    @Column(nullable = false, updatable = false)
    private final Date dateCreated = new Date();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateUpdated = null;
}
