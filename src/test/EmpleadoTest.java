package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okg.Empleado;
import okg.TipoEmpleado;

/**
 * Casos de prueba obtenidos con la técnica de Valores Límite.
 *
 * calculoNominaBruta: tipo (VENDEDOR / ENCARGADO), ventasMes (límites 1000 y
 * 1500) y horasExtra (límite 0).
 *
 * calculoNominaNeta: nominaBruta (límites 2100 y 2500).
 * Criterio: 2100 <= bruta < 2500 -> 15 %; bruta >= 2500 -> 18 %.
 */
class EmpleadoTest {

	private static final float DELTA = 0.01f;

	private Empleado empleado;

	@BeforeEach
	void setUp() {
		empleado = new Empleado();
	}

	// ---------- calculoNominaBruta: ventasMes (vendedor, 0 horas extra) ----------

	@Test
	void brutaVendedorVentas0() {
		assertEquals(2000f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas999_99() {
		assertEquals(2000f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 999.99f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas1000() {
		assertEquals(2100f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas1000_01() {
		assertEquals(2100f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000.01f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas1499_99() {
		assertEquals(2100f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1499.99f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas1500() {
		assertEquals(2200f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500f, 0f), DELTA);
	}

	@Test
	void brutaVendedorVentas1500_01() {
		assertEquals(2200f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500.01f, 0f), DELTA);
	}

	// ---------- calculoNominaBruta: ventasMes (encargado, 0 horas extra) ----------

	@Test
	void brutaEncargadoVentas0() {
		assertEquals(2500f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 0f, 0f), DELTA);
	}

	@Test
	void brutaEncargadoVentas999_99() {
		assertEquals(2500f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 999.99f, 0f), DELTA);
	}

	@Test
	void brutaEncargadoVentas1000() {
		assertEquals(2600f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1000f, 0f), DELTA);
	}

	@Test
	void brutaEncargadoVentas1499_99() {
		assertEquals(2600f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1499.99f, 0f), DELTA);
	}

	@Test
	void brutaEncargadoVentas1500() {
		assertEquals(2700f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1500f, 0f), DELTA);
	}

	@Test
	void brutaEncargadoVentas1500_01() {
		assertEquals(2700f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1500.01f, 0f), DELTA);
	}

	// ---------- calculoNominaBruta: horasExtra ----------

	@Test
	void brutaVendedorHorasExtra0() {
		assertEquals(2000f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0f, 0f), DELTA);
	}

	@Test
	void brutaVendedorHorasExtra1() {
		assertEquals(2030f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0f, 1f), DELTA);
	}

	@Test
	void brutaEncargadoHorasExtra1() {
		assertEquals(2530f, empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 0f, 1f), DELTA);
	}

	@Test
	void brutaVendedorPrimaMaximaConHorasExtra() {
		assertEquals(2500f, empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500f, 10f), DELTA);
	}

	// ---------- calculoNominaNeta ----------

	@Test
	void netaBruta0() {
		assertEquals(0f, empleado.calculoNominaNeta(0f), DELTA);
	}

	@Test
	void netaBruta2099_99() {
		assertEquals(2099.99f, empleado.calculoNominaNeta(2099.99f), DELTA);
	}

	@Test
	void netaBruta2100() {
		assertEquals(1785f, empleado.calculoNominaNeta(2100f), DELTA);
	}

	@Test
	void netaBruta2100_01() {
		assertEquals(1785.0085f, empleado.calculoNominaNeta(2100.01f), DELTA);
	}

	@Test
	void netaBruta2499_99() {
		assertEquals(2124.9915f, empleado.calculoNominaNeta(2499.99f), DELTA);
	}

	@Test
	void netaBruta2500() {
		assertEquals(2050f, empleado.calculoNominaNeta(2500f), DELTA);
	}

	@Test
	void netaBruta2500_01() {
		assertEquals(2050.0082f, empleado.calculoNominaNeta(2500.01f), DELTA);
	}
}
