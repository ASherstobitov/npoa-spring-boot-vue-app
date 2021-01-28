package com.aleksei.npoaspringbootvue.repository;

import com.aleksei.npoaspringbootvue.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long> {

    @Transactional
    @Modifying
    @Query("update ImageData im set im.text = :text, im.num = :num where im.id = :id")
    void updateTextAndNum(@Param("id") Long id, @Param("text") String text, @Param("num") Integer num);
}
