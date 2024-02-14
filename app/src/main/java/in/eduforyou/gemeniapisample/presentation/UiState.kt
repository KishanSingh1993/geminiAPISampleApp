package `in`.eduforyou.gemeniapisample.presentation

import `in`.eduforyou.gemeniapisample.domain.model.ChatMessage

data class UiState(
    val allMessages: List<ChatMessage> = emptyList(),
    var currentPrompt: String = "",
    var responseState: ResponseState = ResponseState.GENERATED
)

enum class ResponseState {
    GENERATING, GENERATED, ERROR
}
