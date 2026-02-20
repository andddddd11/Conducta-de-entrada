package pooconductadeentrada;

import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {
    private List<Cuenta> cuentas;

    public ServiceCuenta() {
        this.cuentas = new ArrayList<>();
    }

    @Override
    public List<Cuenta> listarTodasLasCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenerDatosCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public List<Ahorro> listarCuentasAhorro() {
        List<Ahorro> cuentasAhorro = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Ahorro) {
                cuentasAhorro.add((Ahorro) cuenta);
            }
        }
        return cuentasAhorro;
    }

    public List<Corriente> listarCuentasCorriente() {
        List<Corriente> cuentasCorriente = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof Corriente) {
                cuentasCorriente.add((Corriente) cuenta);
            }
        }
        return cuentasCorriente;
    }
}
