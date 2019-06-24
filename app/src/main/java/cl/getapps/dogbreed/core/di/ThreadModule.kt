package cl.getapps.dogbreed.core.di


import cl.getapps.dogbreed.core.thread.JobExecutor
import cl.getapps.dogbreed.core.thread.PostExecutionThread
import cl.getapps.dogbreed.core.thread.ThreadExecutor
import cl.getapps.dogbreed.core.thread.UiThread
import org.koin.dsl.module

val threadModule = module {
    single { JobExecutor() as ThreadExecutor }
    single { UiThread() as PostExecutionThread }
}
