package kea.exercises.xpbowlingbackendkyll.controller.stock;

import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderRequestDTO;
import kea.exercises.xpbowlingbackendkyll.dtos.stockdtos.ReplacementOrderResponseDTO;
import kea.exercises.xpbowlingbackendkyll.model.stock.ReplacementOrder;
import kea.exercises.xpbowlingbackendkyll.service.stockServices.ReplacementOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            var replacementOrder = replacementOrderService.createReplacementOrder(replacementOrderRequestDTO);
            System.out.println(replacementOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(replacementOrder);

        }

}
