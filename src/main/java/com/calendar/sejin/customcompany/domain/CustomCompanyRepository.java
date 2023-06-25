package com.calendar.sejin.customcompany.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCompanyRepository extends JpaRepository<CustomCompany, Long> {
}
