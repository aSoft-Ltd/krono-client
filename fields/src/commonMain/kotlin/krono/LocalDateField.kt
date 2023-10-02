@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import symphony.BaseField
import kotlin.js.JsExport
import kotlin.js.JsName

interface LocalDateField : BaseField<LocalDate> {
    @JsName("setIso")
    fun set(iso: String?)
}