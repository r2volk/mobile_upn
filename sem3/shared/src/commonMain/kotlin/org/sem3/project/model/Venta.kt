package org.sem3.project.model

data class Venta(
    // entradas
    val marca: String = "NIKE",
    val talla: String = "TALLA38",
    val cantidadTexto: String = "",

    // resultados (se llenan cuando se toca "calcular")
    val costoUnitario: Double = 0.0,
    val ventaNeta: Double = 0.0,
    val ventaBruta: Double = 0.0,
    val descuento: Double = 0.0,

    // nos dicen si ya presionamos el boton "calcular" para mostrar los datos
    val estaCalculado: Boolean = false
)
