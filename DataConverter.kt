package com.sarang.torang.di.restaurant_review_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.data.Feed
import com.sarang.torang.data.remote.response.FeedApiModel


fun FeedApiModel.toFeedData(): Feed {
    return Feed(
        reviewId = this.reviewId,
        userId = this.user.userId,
        userName = this.user.userName,
        restaurantName = this.restaurant.restaurantName ?: "",
        rating = this.rating,
        profilePicUrl = BuildConfig.PROFILE_IMAGE_SERVER_URL + this.user.profilePicUrl,
        likeAmount = this.like_amount,
        commentAmount = this.comment_amount,
        //isLike = this.like != null,
        //isFavorite = this.favorite != null,
        //visibleLike = false,
        //visibleComment = false,
        contents = this.contents,
        //reviewImages = this.pictures.map { BuildConfig.REVIEW_IMAGE_SERVER_URL + it.picture_url },
        restaurantId = this.restaurant.restaurantId ?: -1
    )
}