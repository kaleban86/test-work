package com.technology.testwork.repository;


import com.technology.testwork.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language,Long> {


    public Language findByName(String name);

    @Modifying
    @Query(value = "update Language set description=:description,rating=:rating where name=:name",nativeQuery = true)
    public void updateByName(@Param(value = "name") String name,@Param(value = "description") String description,@Param("rating") Long rating);

    public void deleteAllByName(String name);
}
