package `in`.eduforyou.gemeniapisample.infrastructure.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.eduforyou.gemeniapisample.data.repository.InMemoryChatRepository
import `in`.eduforyou.gemeniapisample.data.source.GeminiProDataSource
import `in`.eduforyou.gemeniapisample.domain.repository.ChatRepository
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
object HiltAppModule {

    @Provides
    @Singleton
    fun provideGeminiProDataSource(): GeminiProDataSource {
        return GeminiProDataSource("AIzaSyAEXaFjLCc7MYmmHOp0NQiW9lH7bPXuK18")
    }

    @Provides
    @Singleton
    fun provideChatRepository(geminiProDataSource: GeminiProDataSource): ChatRepository {
        return InMemoryChatRepository(geminiProDataSource)
    }

}
