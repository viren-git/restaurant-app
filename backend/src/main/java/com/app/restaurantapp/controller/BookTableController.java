package com.app.restaurantapp.controller;

import com.app.restaurantapp.model.Table;
import com.app.restaurantapp.service.BookTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class BookTableController {

    @Autowired
    BookTableService bookTableService;

    @GetMapping("tables/{startTime}/{endTime}")
    public ResponseEntity<List<Table>> getTableDetails(@PathVariable("startTime") String startTime,
                                                       @PathVariable("endTime") String endTime){
         List<Table> tableDetails = bookTableService.getTableDetailsByStartAndEndTime(startTime,endTime);
        return new ResponseEntity<>(tableDetails, HttpStatus.OK);
    }

    @GetMapping("tables/booked")
    public ResponseEntity<List<Table>> getBookedTableDetails(){
        List<Table> tableDetails = bookTableService.getBookedTableDetails();
        return new ResponseEntity<>(tableDetails, HttpStatus.OK);
    }

    @GetMapping("tables/{id}")
    public ResponseEntity<Optional<Table>> getTableDetailsById(@PathVariable("id") Long id){
        Optional<Table> tableDetails = bookTableService.getTableDetailsById(id);
        return new ResponseEntity<>(tableDetails, HttpStatus.OK);
    }

    @PutMapping("tables/book")
    public ResponseEntity<Table> bookTable(@RequestBody Table table){
        Table tableDetails = bookTableService.bookTable(table);
        return new ResponseEntity<>(tableDetails, HttpStatus.OK);
    }

    @PutMapping("tables/cancel")
    public ResponseEntity<Table> cancelBooking(@RequestBody Table table){
        Table tableDetails = bookTableService.cancelBooking(table);
        return new ResponseEntity<>(tableDetails, HttpStatus.OK);
    }
}
