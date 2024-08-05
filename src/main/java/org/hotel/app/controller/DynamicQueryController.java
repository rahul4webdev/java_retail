package org.hotel.app.controller;
import org.hotel.app.dto.Api;
import org.hotel.app.service.DynamicQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class DynamicQueryController {
    @Autowired
    private DynamicQueryService dynamicQueryService;
    
    @GetMapping("/executeQuery")
    public ResponseEntity<List<Object[]>> executeDynamicQuery(
            @RequestParam String sqlQuery) {
        List<Object[]> results = dynamicQueryService.executeDynamicQuery(sqlQuery);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/executeUpdate")
    public ResponseEntity<String> executeUpdateQuery(
            @RequestParam String sqlQuery) {
        try {
            int rowsAffected = dynamicQueryService.executeUpdateQuery(sqlQuery);
            return ResponseEntity.ok("Rows affected: " + rowsAffected);
        } catch (Exception e) {
            // Provide a meaningful error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error executing update query: " + e.getMessage());
        }
    }

}
