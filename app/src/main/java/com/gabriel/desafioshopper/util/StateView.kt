package com.gabriel.desafioshopper.util

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

sealed class StateView<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : StateView<T>(data = null, message = null)

    class Error<T>(message: String?) : StateView<T>(message = message)

    class Success<T>(data: T, message: String? = null) : StateView<T>(data = data, message = message)
}

fun Float?.formattedValue(removeSymbol: Boolean = false): String {
    val moneyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    moneyFormatter.currency = Currency.getInstance("BRL")

    val value = if (this == null) {
        moneyFormatter.format(0f)
    } else {
        moneyFormatter.format(this)
    }

    return if (removeSymbol) value.replace("R\$ ", "") else value
}