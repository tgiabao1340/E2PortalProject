package se.iuh.e2portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class TimeTable {
    @Id
    @GenericGenerator(name = "sequence_long_id", strategy = "se.iuh.e2portal.generator.LongGenerator")
    @GeneratedValue(generator = "sequence_long_id")
    private Long timeTableId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "moduleClassId", referencedColumnName = "moduleClassId")
    private ModuleClass moduleClass;
    private String classRoom;
    private String dayOfWeek;
    private String period;
    private Date startDate;
    private Date endDate;

}
