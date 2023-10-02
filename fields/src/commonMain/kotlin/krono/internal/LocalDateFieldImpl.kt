package krono.internal

import krono.LocalDate
import neat.ValidationFactory
import symphony.Changer
import krono.LocalDateField
import symphony.Visibility
import symphony.internal.BaseFieldImpl
import kotlin.reflect.KMutableProperty0

@PublishedApi
internal class LocalDateFieldImpl(
    name: KMutableProperty0<LocalDate?>,
    label: String,
    visibility: Visibility,
    hint: String,
    onChange: Changer<LocalDate>?,
    factory: ValidationFactory<LocalDate>?
) : BaseFieldImpl<LocalDate>(name, label, visibility, hint, onChange, factory), LocalDateField {
    override fun set(iso: String?) = set(LocalDate(iso).getOrNull())
}