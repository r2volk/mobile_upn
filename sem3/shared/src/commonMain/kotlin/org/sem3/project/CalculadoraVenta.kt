package org.sem3.project

import org.sem3.project.model.Venta

object CalculadoraVenta {

    private fun obtenerPrecioUnitario(marca: String, talla: String): Double{
        if (marca == "NIKE"){
            if (talla == "TALLA 38"){
                return 150.0
            }
            return 160.0
        } else if (marca == "ADIDAS"){
            if (talla == "TALLA 38"){
                return 140.0
            }
            return 150.0
        } else {
            if (talla == "TALLA 38"){
                return 80.0
            } else if (talla == "TALLA 40"){
                return 85.0
            }
            return 90.0
        }
    }

    private fun obtenerPorcentajeDescuento(pares: Int): Double {
        return when {
            pares in 2..5 -> 0.05       // 5%
            pares in 6..10 -> 0.08      // 8%
            pares in 11..20 -> 0.10     // 10%
            pares > 20 -> 0.15               // 15%
            else -> 0.0                      // 0% (si compra 1 par)
        }
    }

    fun procesar(ventaActual: Venta): Venta{

        // convierte la cantidad de pares a entero
        val pares = ventaActual.cantidadTexto.toIntOrNull() ?: 0

        // si el usuario ingreso un numero invalido o puso 0, no calculamos nada
        if (pares <= 0) {
            return ventaActual.copy(estaCalculado = false)
        }

        val costo = obtenerPrecioUnitario(ventaActual.marca, ventaActual.talla)
        val porcentajeDesc = obtenerPorcentajeDescuento(pares)
        val desc = (costo * pares)* porcentajeDesc

        return ventaActual.copy(
            costoUnitario = costo,
            ventaBruta = costo * pares,
            descuento = desc,
            ventaNeta = (costo * pares) - desc,
            estaCalculado = true
        )
    }


}