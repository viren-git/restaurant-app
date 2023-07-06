package com.app.restaurantapp.repository;

import com.app.restaurantapp.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

    @Query(value = "SELECT * from tables t where t.table_book_start_time =:startTime " +
            "AND t.table_book_end_time = :endTime AND t.table_status='Available'", nativeQuery = true)
    List<Table> findByStartAndEndTime(@Param("startTime") String startTime, @Param("endTime")String endTime);

    @Query(value = "SELECT * from tables t where t.table_status='Booked'", nativeQuery = true)
    List<Table> findAllByStatusBooked();

    @Query(value = "SELECT * from tables t where t.table_status = 'Available'", nativeQuery = true)
    List<Table> findAllByStatusAvailable();

    @Query(value = "SELECT * from tables t where t.table_status = 'Available' AND t.number=:tableNumber", nativeQuery = true)
    Table findTableByStatusAvailable(@Param("tableNumber") long tableNumber);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tables t set t.table_status='Available',t.table_booked_date='' where t.number =:tableNumber ", nativeQuery = true)
    void cancelBookingForTable(@Param("tableNumber") long tableNumber);
}