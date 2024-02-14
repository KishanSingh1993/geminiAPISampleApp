package `in`.eduforyou.gemeniapisample.domain.repository

import `in`.eduforyou.gemeniapisample.domain.model.ChatMessage
import kotlinx.coroutines.flow.Flow

/*
* Sample shows implementation of only 1 chat, you can add multiple chats support
* */
interface ChatRepository {
    suspend fun saveMessage(chatMessage: ChatMessage)
    fun getAllMessages(): List<ChatMessage>
    fun subscribeMessages(): Flow<List<ChatMessage>>
}
