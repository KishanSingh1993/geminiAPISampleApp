package `in`.eduforyou.gemeniapisample.domain.model

import java.util.Date

data class ChatMessage(
    val id: Long = 0,
    val message: String,
    val role: Role,
    val timestamp: Date
)

enum class Role {
    USER, MODEL
}
