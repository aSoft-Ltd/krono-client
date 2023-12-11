@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import cinematic.Live
import kotlinx.JsExport

/**
 * A durator is a client in memory service that helps in computing duration for the entire app
 * It offloads all duration counts in its one timing function which aids in performing more with
 * less resources
 */
interface Durator {

    /**
     * Should start the durator.
     *
     * Normally a durator should auto start and auto stop based on the number of available
     * instants submitted on [durate]
     * @param force when set to true, it indicates whether the durator should force start
     * @see stop
     * @return [DuratorStartResults]
     * @return [DuratorStartResults.Started] | [DuratorStartResults.AlreadyStarted] when [force] = true
     */
    fun start(force: Boolean? = null): DuratorStartResults

    /**
     * Submits an [Instant] to the durator for computation
     * @see remove
     * @param i - the instance to be submitted
     */
    fun durate(i: Instant): Live<Durated>

    /**
     * Remove the [Instant] to the durator for computation
     * @see start
     * @param i - the instance to be submitted
     */
    fun remove(i: Instant)

    /**
     * Should stop the durator
     * @see start
     * @param force when set to true, it indicates whether the durator should force stop
     * @return [DuratorStopResults]
     * @return [DuratorStopResults.Stopped] | [DuratorStopResults.AlreadyStopped] when [force] = true
     */
    fun stop(force: Boolean? = null): DuratorStopResults
}