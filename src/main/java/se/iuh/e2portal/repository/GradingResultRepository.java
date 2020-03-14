package se.iuh.e2portal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iuh.e2portal.model.GradingResult;
import se.iuh.e2portal.model.Student;

import java.util.List;

@Repository
public interface GradingResultRepository extends CrudRepository<GradingResult,Long> {

    @Query("select g from GradingResult g where g.student = ?1")
    List<GradingResult> findByStudent(Student student);
}
