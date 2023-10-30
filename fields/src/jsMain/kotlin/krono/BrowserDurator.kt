package krono

import cinematic.Live
import cinematic.MutableLive
import cinematic.mutableLiveOf

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

    private var timer: IntervalTimer? = null
    override fun start(force: Boolean?): DuratorStartResults {
        if (timer != null) return DuratorStartResults.AlreadyStarted
        if (instants.isEmpty() && force != true) return DuratorStartResults.NoNeedToStart
        timer = setInterval({
            for ((i, r) in instants) r.live.value = Instant(i).passed()
        }, 1000)
        return DuratorStartResults.Started
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

    override fun stop(force: Boolean?) : DuratorStopResults {
        val i = timer ?: return DuratorStopResults.AlreadyStopped
        if(instants.isNotEmpty() && force!=true) return DuratorStopResults.NoNeedToStop
        clearInterval(i)
        timer = null
        return DuratorStopResults.Stopped
    }
}