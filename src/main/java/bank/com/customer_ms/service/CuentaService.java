package bank.com.customer_ms.service;

import bank.com.customer_ms.model.Cuenta;
import bank.com.customer_ms.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    // Método para retirar dinero de una cuenta
    public boolean retirar(Long cuentaId, double monto) {
        // Buscar la cuenta por ID
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElse(null);

        // Verificar si la cuenta existe y si tiene suficiente saldo
        if (cuenta != null && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto); // Realizar el retiro
            cuentaRepository.save(cuenta); // Guardar la cuenta con el saldo actualizado
            return true;
        }
        return false; // Si no existe la cuenta o no tiene suficiente saldo
    }

    // Otros métodos según sea necesario (ej. consultar saldo, crear cuenta, etc.)
}
