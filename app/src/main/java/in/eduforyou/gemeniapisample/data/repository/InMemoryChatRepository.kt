package `in`.eduforyou.gemeniapisample.data.repository

import `in`.eduforyou.gemeniapisample.data.source.GeminiProDataSource
import `in`.eduforyou.gemeniapisample.domain.model.ChatMessage
import `in`.eduforyou.gemeniapisample.domain.model.Role
import `in`.eduforyou.gemeniapisample.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date

/*
* This sample stores chats in memory. You can use Room persistence.
* */
class InMemoryChatRepository(
    private val geminiPro: GeminiProDataSource
): ChatRepository {

    private val messages = MutableStateFlow(emptyList<ChatMessage>())
    private var sequence: Long = 1

    override suspend fun saveMessage(chatMessage: ChatMessage) {
        messages.update {
            messages.value.toMutableList().apply { this.add(chatMessage.copy(id = sequence)) }
        }
        sequence += 1
        if (chatMessage.role == Role.USER)
            generateChatResponseAndSave(chatMessage.message)
    }

    override fun getAllMessages(): List<ChatMessage> {
        return messages.value.toMutableList()
    }

    override fun subscribeMessages(): Flow<List<ChatMessage>> {
        return messages
    }

    private suspend fun generateChatResponseAndSave(message: String) {
        val chatResponse = geminiPro.generateOngoingChatResponse(message)
        saveMessage(ChatMessage(0, chatResponse, Role.MODEL, Date()))
    }

}
