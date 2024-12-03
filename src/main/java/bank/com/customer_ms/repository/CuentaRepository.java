package bank.com.customer_ms.repository;

import bank.com.customer_ms.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    // Agrega aquí cualquier consulta personalizada si es necesario
}

