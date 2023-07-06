package com.app.restaurantapp.service;

import com.app.restaurantapp.model.Table;
import com.app.restaurantapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTableService {

    @Autowired
    TableRepository tableRepository;

    public Optional<Table> getTableDetailsById(Long id){
        return this.tableRepository.findById(id);
    }

    public List<Table> getTableDetailsByStartAndEndTime(String startTime, String endTime){
        return this.tableRepository.findByStartAndEndTime(startTime, endTime);
    }

    public List<Table> getBookedTableDetails(){
        return this.tableRepository.findAllByStatusBooked();
    }

    public Table bookTable(Table table){
        return this.tableRepository.save(table);
    }

    public Table cancelBooking(Table table){
        this.tableRepository.cancelBookingForTable(table.getNumber());
        return this.tableRepository.findTableByStatusAvailable(table.getNumber());
    }
}
