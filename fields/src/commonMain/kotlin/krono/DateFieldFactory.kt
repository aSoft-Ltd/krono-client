package krono

import neat.ValidationFactory
import krono.internal.LocalDateFieldImpl
import symphony.Changer
import symphony.Fields
import symphony.Visibility
import kotlin.reflect.KMutableProperty0
import symphony.Visibilities

fun Fields<*>.date(
    name: KMutableProperty0<LocalDate?>,
    label: String = name.name,
    hint: String = label,
    visibility: Visibility = Visibilities.Visible,
    onChange: Changer<LocalDate>? = null,
    factory: ValidationFactory<LocalDate>? = null
): LocalDateField = getOrCreate(name) {
    LocalDateFieldImpl(name, label, visibility, hint, onChange, factory)
}