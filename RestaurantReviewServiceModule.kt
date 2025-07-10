package com.sarang.torang.di.restaurant_review_di

import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.handle
import com.sarang.torang.data.Feed
import com.sarang.torang.usecase.FetchReviewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.HttpException
import kotlin.collections.map

@InstallIn(SingletonComponent::class)
@Module
class RestaurantReviewServiceModule {
    @Provides
    fun providesFetchReviewsUseCase(apiReview: ApiReview): FetchReviewsUseCase {
        return object : FetchReviewsUseCase {
            override suspend fun invoke(restaurantId: Int): List<Feed> {
                try {
                    return apiReview.getReviews(restaurantId).map { it.toFeedData() }
                } catch (e: HttpException) {
                    throw Exception(e.handle())
                }
            }
        }
    }

}