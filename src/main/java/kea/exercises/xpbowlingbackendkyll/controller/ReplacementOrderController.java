package kea.exercises.xpbowlingbackendkyll.controller;

import kea.exercises.xpbowlingbackendkyll.dtos.ReplacementOrderRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.ReplacementOrderResponseDTO;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.service.ReplacementOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/replacementorders")
public class ReplacementOrderController {

        private final ReplacementOrderService replacementOrderService;

        public ReplacementOrderController(ReplacementOrderService replacementOrderService) {
            this.replacementOrderService = replacementOrderService;
        }

        @GetMapping
        public List<ReplacementOrder> getAllReplacementOrders() {
            return replacementOrderService.findAllReplacementOrders();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ReplacementOrder> getReplacementOrderById(@PathVariable int id) {
            return ResponseEntity.of(replacementOrderService.getReplacementOrderById(id));
        }

        @PostMapping
        public ResponseEntity<ReplacementOrderResponseDTO> addReplacementOrder(@RequestBody ReplacementOrderRequestDTO replacementOrderRequestDTO) {
            System.out.println(replacementOrderRequestDTO);
            System.out.println("we are in the controller now");
            return ResponseEntity.status(HttpStatus.CREATED).body(replacementOrderService.createReplacementOrder(replacementOrderRequestDTO));

        }

}
