@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import symphony.BaseField
import kotlin.js.JsExport

interface LocalDateTimeField : BaseField<DateTimePresenter> {

    fun setDateTimeIso(iso: String?)

    fun setDateIso(iso: String?)

    fun setTimeIso(iso: String?)
}