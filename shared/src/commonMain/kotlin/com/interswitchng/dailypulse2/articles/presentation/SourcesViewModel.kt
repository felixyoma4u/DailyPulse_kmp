package com.interswitchng.dailypulse2.articles.presentation

import com.interswitchng.dailypulse2.BaseViewModel
import com.interswitchng.dailypulse2.articles.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val useCase: SourceUseCase
) : BaseViewModel() {

    private val _sourcesState: MutableStateFlow<SourcesState> =
        MutableStateFlow(SourcesState(loading = true))

    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        getSources()
    }

    private fun getSources(){
        scope.launch {
            _sourcesState.emit(
                SourcesState(
                    sources = _sourcesState.value.sources,
                    loading = true,
                    error = null
                )
            )

            val fetchSources = useCase.getSources()
            _sourcesState.emit(SourcesState(sources = fetchSources))
        }
    }
}