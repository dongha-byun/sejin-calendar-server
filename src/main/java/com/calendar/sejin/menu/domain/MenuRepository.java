package com.calendar.sejin.menu.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    /**
     * select *
     * from menu
     * where menu_id in ?menuIds
     * order by id, menu_order
     */
    @Query(value = "select m from Menu m where m.id in :menuIds order by m.parent, m.order")
    List<Menu> findAllMenus(@Param("menuIds") List<String> menuIds);
}
