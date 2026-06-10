package in.varun.productcatalogservice.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BaseModel {
      /*
    -> id                                     : Long
    -> createdAt                        : Date
    -> lastUpdatedAt                 : Date
    -> state                                : Enum
     */
    private Long id;
    private Data createdAt;
    private Data lastUpdatedAt;
    private StateModel state;
}
