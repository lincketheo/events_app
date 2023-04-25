package com.communeo.mobile.android.features.feed.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.communeo.mobile.android.core.logging.CommuneoLoggerFactory
import com.communeo.mobile.android.features.feed.domain.GetEventFeedUseCase
import com.communeo.mobile.android.features.feed.ui.models.FeedEventCardUiState
import com.communeo.mobile.android.features.feed.ui.models.FeedUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PagingFeedViewModel @Inject constructor(
    private val getEventFeed: GetEventFeedUseCase,
) : ViewModel() {
    private val logger = CommuneoLoggerFactory.getLogger(this)

    private val _uiState = MutableStateFlow(FeedUiState.initial)
    val uiState = _uiState.asStateFlow()

    private var fetchJob: Job? = null
    private var page = 0U
    private val pageSize = 10U
    private val triggerNumber = 3

    fun consume(eventId: Int) {
        logger.debug("Consuming event $eventId")
        if (eventId > _uiState.value.eventsShowing.size - triggerNumber) {
            logger.debug("There are not enough events shown on the screen, fetching new events")
            fetchJob?.let {
                if (!it.isActive) {
                    fetchJob = createFetchJob()
                } else {
                    logger.debug("There is already a fetch job happening in the background")
                }
            } ?: run {
                fetchJob = createFetchJob()
            }
        }
    }

    private fun createFetchJob() = viewModelScope.launch {
        // Set loading to true
        _uiState.update {
            it.copy(isLoading = true)
        }

        // Fetch events
        logger.debug("Fetching events")
        val events = getEventFeed(page, pageSize)

        page += 1U
        logger.debug("Fetched ${events.size} events")

        // Update UI
        _uiState.update {
            it.copy(
                eventsShowing = it.eventsShowing + events.map { event ->
                    FeedEventCardUiState.initial(
                        event
                    )
                },
                isLoading = false,
            )
        }

        logger.debug("Events fetch job complete")
    }
}
