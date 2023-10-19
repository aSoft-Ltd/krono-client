package krono

import cinematic.Live

interface Durator {
    fun durate(i: Instant) : Live<String>

    fun remove(i: Instant)
}