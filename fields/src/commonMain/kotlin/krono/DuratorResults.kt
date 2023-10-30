@file:JsExport
package krono

import kotlin.js.JsExport

enum class DuratorStartResults {
    AlreadyStarted,
    NoNeedToStart,
    Started
}

enum class DuratorStopResults {
    AlreadyStopped,
    NoNeedToStop,
    Stopped
}