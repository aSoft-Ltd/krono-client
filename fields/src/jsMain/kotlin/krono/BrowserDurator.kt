package krono

import cinematic.Live
import cinematic.MutableLive
import cinematic.mutableLiveOf
import koncurrent.setTimeout
import kotlinx.browser.window

class BrowserDurator(private val clock: Clock) : Durator {
    private val instants = mutableMapOf<Long, ReferenceLive>()

    class ReferenceLive(
        var count: Int,
        val live: MutableLive<String>
    )

    private fun Instant.passed() = Duration(
        value = clock.currentSecondsAsDouble() - epochSeconds.toDouble(),
        unit = DurationUnit.Seconds
    ).toRelativeString()

    private var handler: Int? = null
    fun start() {
        if (handler != null) return
        handler = setTimeout({
            for ((i, r) in instants) r.live.value = Instant(i).passed()
        }, 1000)
    }

    override fun durate(i: Instant): Live<String> {
        val live = instants.getOrPut(i.epochMilliSecondsAsLong) {
            ReferenceLive(1, mutableLiveOf(i.passed()))
        }
        start()
        return live.live
    }

    override fun remove(i: Instant) {
        val ref = instants[i.epochMilliSecondsAsLong] ?: return
        ref.count--
        if (ref.count == 0) {
            instants.remove(i.epochMilliSecondsAsLong)
        }
        if (instants.isEmpty()) stop()
    }

    fun stop() {
        val h = handler ?: return
        window.clearTimeout(h)
        handler = null
    }
}