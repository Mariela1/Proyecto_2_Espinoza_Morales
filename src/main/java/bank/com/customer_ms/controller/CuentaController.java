package bank.com.customer_ms.controller;

import bank.com.customer_ms.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Endpoint para retirar dinero
    @PutMapping("/{cuentaId}/retirar")
    public ResponseEntity<String> retirar(@PathVariable Long cuentaId, @RequestParam double monto) {
        if (monto <= 0) {
            return ResponseEntity.badRequest().body("El monto debe ser mayor que 0");
        }

        // Llamar al método retirar de la instancia de CuentaService
        boolean exito = cuentaService.retirar(cuentaId, monto);
        if (exito) {
            return ResponseEntity.ok("Retiro exitoso");
        } else {
            return ResponseEntity.status(404).body("Cuenta no encontrada o saldo insuficiente");
        }
    }

    // Otros endpoints según sea necesario (ej. ver saldo, crear cuenta, etc.)
}

