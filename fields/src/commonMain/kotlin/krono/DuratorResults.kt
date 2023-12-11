@file:JsExport
package krono

import kotlinx.JsExport

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