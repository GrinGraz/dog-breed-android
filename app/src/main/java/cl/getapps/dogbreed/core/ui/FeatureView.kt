package cl.getapps.dogbreed.core.ui

import cl.getapps.dogbreed.core.data.StateData

interface FeatureView {
    fun render(stateData: StateData)

    interface Pageable
}
