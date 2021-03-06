package se.iuh.e2portal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.iuh.e2portal.model.MainClass;
import se.iuh.e2portal.model.Student;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(itemResourceRel = "student", collectionResourceRel = "students", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student,String> {
//    @Query("select s from Student s where s.lastName like ?1")
//    List<Student> findByName(String name);
//    @Query("select s from Student s where s.classId = ?1")
//    List<Student> findByClass(Class aClass);
    @Query("select s from Student s where s.mainClass = ?1")
    List<Student> findByMainClass(MainClass clazz);

    @Query("select  s from  Student s where s.id = ?#{ principal.id}")
    Optional<Student> profile();

    @Query("select  s from  Student s where s.familyNumber = ?#{ principal.id}")
    List<Student> getByParent();

    @Query("select p.lastName, p.firstName from Student p where p.familyNumber = :parentId")
	List<String> getStudentNameByParent(@Param("parentId") String parentId);
}
