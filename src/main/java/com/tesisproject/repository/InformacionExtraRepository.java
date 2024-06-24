package com.tesisproject.repository;

import com.tesisproject.entity.InformacionExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionExtraRepository extends JpaRepository<InformacionExtra, Long> {
}
