package cl.getapps.dogbreed.core.thread

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}
