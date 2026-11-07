package com.ciro.dispositivos

// data class genera sola equals, hashCode, toString y copy a partir de sus propiedades.
// val es una propiedad de solo lectura; String? permite que el valor sea null.
data class Specs (
    val color: String?,
    val capacity: String?
)
