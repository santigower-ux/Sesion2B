package okg;


public class Empleado {


	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float sueldo=0;
		if(tipo==TipoEmpleado.ENCARGADO) {
			sueldo = 2500;
		}else if(tipo==TipoEmpleado.VENDEDOR) {
			sueldo = 2000;
		}

		if (ventasMes >= 1500) {
			sueldo += 200;
		} else if (ventasMes >= 1000) {
			sueldo += 100;
		}

		return sueldo + horasExtra * 30;
	}

	public static float calculoNominaNeta(float nominaBruta) {
		float retencion;
		if (nominaBruta < 2100) {
			retencion = 0;
		} else if (nominaBruta < 2500) {
			retencion = 0.15f;
		} else {
			retencion = 0.18f;
		}
		return nominaBruta * (1 - retencion);
	}
}
