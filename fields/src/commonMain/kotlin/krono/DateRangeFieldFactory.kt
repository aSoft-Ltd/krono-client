package krono

import neat.ValidationFactory
import krono.internal.LocalDateRangeFieldImpl
import symphony.Changer
import symphony.Fields
import symphony.Range
import symphony.Visibility
import kotlin.reflect.KMutableProperty0
import symphony.Visibilities

fun Fields<*>.range(
    name: KMutableProperty0<Range<LocalDate>?>,
    label: String = name.name,
    visibility: Visibility = Visibilities.Visible,
    onChange: Changer<Range<LocalDate>>? = null,
    factory: ValidationFactory<Range<LocalDate>>? = null
): LocalDateRangeField = getOrCreate(name) {
    LocalDateRangeFieldImpl(name, label, visibility, onChange, factory)
}