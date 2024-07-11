package krono.internal

import krono.LocalDate
import neat.ValidationFactory
import symphony.Changer
import krono.LocalDateField
import symphony.Visibility
import symphony.internal.FieldBacker
import symphony.internal.GenericBaseField

@PublishedApi
internal class LocalDateFieldImpl(
    backer: FieldBacker<LocalDate>,
    value: LocalDate?,
    label: String,
    visibility: Visibility,
    hint: String,
    onChange: Changer<LocalDate>?,
    factory: ValidationFactory<LocalDate>?
) : GenericBaseField<LocalDate>(backer, value, label, visibility, hint, onChange, factory), LocalDateField {
    override fun set(iso: String?) = set(LocalDate(iso).getOrNull())
}