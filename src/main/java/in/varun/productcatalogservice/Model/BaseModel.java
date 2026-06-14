package in.varun.productcatalogservice.Model;

import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
    /*
    -> id                                     : Long
    -> createdAt                        : Date
    -> lastUpdatedAt                 : Date
    -> state                                : Enum
     */

    @Id
    private Long id;
    private Date createdAt; //store data in epoch format-> HW
    private Date lastUpdatedAt;
    private State state;

}
