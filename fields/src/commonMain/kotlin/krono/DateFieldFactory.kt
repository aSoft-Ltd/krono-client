package krono

import neat.ValidationFactory
import krono.internal.LocalDateFieldImpl
import symphony.Changer
import symphony.Fields
import symphony.Visibility
import kotlin.reflect.KMutableProperty0
import symphony.Visibilities
import symphony.internal.FieldBacker

fun Fields<*>.date(
    name: KMutableProperty0<LocalDate?>,
    value: LocalDate? = name.get(),
    label: String = name.name,
    hint: String = label,
    visibility: Visibility = Visibilities.Visible,
    onChange: Changer<LocalDate>? = null,
    factory: ValidationFactory<LocalDate>? = null
): LocalDateField = getOrCreate(name) {
    LocalDateFieldImpl(FieldBacker.Prop(name), value, label, visibility, hint, onChange, factory)
}

fun LocalDateField(
    name: String = "Date",
    value: LocalDate? = null,
    label: String = name,
    hint: String = label,
    visibility: Visibility = Visibilities.Visible,
    onChange: Changer<LocalDate>? = null,
    factory: ValidationFactory<LocalDate>? = null
): LocalDateField = LocalDateFieldImpl(FieldBacker.Name(name), value, label, visibility, hint, onChange, factory)