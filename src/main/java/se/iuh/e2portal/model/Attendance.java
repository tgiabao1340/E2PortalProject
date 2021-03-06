package se.iuh.e2portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Data
@ToString
public class Attendance {
	
    @Id
    @GenericGenerator(name = "sequence_long_id", strategy = "se.iuh.e2portal.generator.LongGenerator")
    @GeneratedValue(generator = "sequence_long_id")
    private Long attendanceId;
    private Date dateOff;
    private boolean allowed;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id")
    private Student student;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "moduleClassId")
    private ModuleClass moduleClass;
    
    public String getFormattedDateOff(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(dateOff);
    }
    public String getModuleClassId(){
        return moduleClass.getModuleClassId();
    }
}
