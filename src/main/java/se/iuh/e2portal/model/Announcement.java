package se.iuh.e2portal.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Data
public class Announcement {

    @Id
    @GenericGenerator(name = "sequence_long_id", strategy = "se.iuh.e2portal.generator.LongGenerator")
    @GeneratedValue(generator = "sequence_long_id")
    private Long announcementId;
    private String title;
    private String summary;
    @Column(columnDefinition = "nvarchar(8000)")
    private String contentDetail;
    private Date createdDate;
    
    public String getFormattedCreatedDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(createdDate);
    }

}
