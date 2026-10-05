package okg;

public class Empleado {

	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float salario = (tipo == TipoEmpleado.ENCARGADO) ? 2500f : 2000f;

		if (ventasMes >= 1500f) {
			salario += 200f;
		} else if (ventasMes >= 1000f) {
			salario += 100f;
		}

		return salario + horasExtra * 30f;
	}

	public float calculoNominaNeta(float nominaBruta) {
		float retencion;
		if (nominaBruta < 2100f) {
			retencion = 0f;
		} else if (nominaBruta < 2500f) {
			retencion = 0.15f;
		} else {
			retencion = 0.18f;
		}
		return nominaBruta * (1 - retencion);
	}
}
