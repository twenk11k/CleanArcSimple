package com.twenk11k.cleanarcsimple.network

import com.twenk11k.cleanarcsimple.base.MainCoroutinesRule
import com.twenk11k.cleanarcsimple.di.ListingService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class ListingServiceTest : ApiBase<ListingService>() {

    private lateinit var service: ListingService

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @Before
    fun initService() {
        service = createService(ListingService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun getListingsTest(): Unit = runBlocking {
        enqueueResponse("/Listing.json")
        val response = service.getListings()
        mockWebServer.takeRequest()

        response.body()?.results?.get(0)?.let {
            MatcherAssert.assertThat(it.name, CoreMatchers.`is`("Notebook"))
            MatcherAssert.assertThat(it.uid, CoreMatchers.`is`("4878bf592579410fba52941d00b62f94"))
            MatcherAssert.assertThat(it.price, CoreMatchers.`is`("AED 5"))
            MatcherAssert.assertThat(it.createdAt, CoreMatchers.`is`("2019-02-24 04:04:17.566515"))
            MatcherAssert.assertThat(
                it.imageIds?.get(0),
                CoreMatchers.`is`("9355183956e3445e89735d877b798689")
            )
            MatcherAssert.assertThat(
                it.imageUrls?.get(0),
                CoreMatchers.`is`("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4SA7T7ZPK&Signature=bVrftm67%2FraiSaGZwHe7ZCCswio%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEEwaCXVzLWVhc3QtMSJIMEYCIQDAzRlhZyD0ZciC1ILFhzeY1jfXVYoFU1pJFlUZKreELAIhAISM4%2Fo9iNvZucZXvukP%2BN7%2FTqP888AoUKJ675x4ZSUWKpQCCGUQAxoMMTg0Mzk4OTY2ODQxIgy%2BhEkmjzCm04aPKzIq8QH4x9F0j2SsNVk5QBnCUBxkwH50BO8p%2FGfhV94RH90weBYj0CDYYYOa5tUxXhiQTkWOCguL0lQa7bJNBZQIGxgn%2BSaZQ%2FOYx9U%2B%2BJz4notoI80AnVcZcWVsYmrawfd33VtSQ9Fb6LJ7U%2F2hcpdmTDobQGsCD%2FSh9zKfiun5zZ6zJb7ZewR%2B1RAnLvz5yFHI%2BDmhy5lr9G48stGqqNHA2D0cpCJoVgww5OhV0z3HAdAy8u5B7L4B%2B3gORRfjupp5SZV3w7XeUH56%2BtHLg08qFIO%2BZGwxi%2FhfddMX4T9Co0Bgl6X8ggYgTjzlKwp2nwYKq0pOMJfnzZUGOpkB5dvfdXmV4ZB9Z2oj7mUl6nbmZdrS7kj%2FcL4rlaiYwxGBJ%2F8x4RPLd%2BuvCURQzsDCe2OyqINpBQ9eY%2B0suZAx0bDsVsJFhOe7NlGnySTRwRc9ldVo2L8n5VfubnNjfYmIlrrcUXQO1r2SF%2B8GJI434klRgEbctpB%2F6C4peXMMDXm8GBzE2nqdZxgRHgKOKqHp3CxMu0Gx3FYZ&Expires=1655931306")
            )
            MatcherAssert.assertThat(
                it.imageUrlsThumbnails?.get(0),
                CoreMatchers.`is`("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689-thumbnail?AWSAccessKeyId=ASIASV3YI6A4SA7T7ZPK&Signature=HazXlQqkVwSXFN4PkfIRW%2FN0%2BjM%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEEwaCXVzLWVhc3QtMSJIMEYCIQDAzRlhZyD0ZciC1ILFhzeY1jfXVYoFU1pJFlUZKreELAIhAISM4%2Fo9iNvZucZXvukP%2BN7%2FTqP888AoUKJ675x4ZSUWKpQCCGUQAxoMMTg0Mzk4OTY2ODQxIgy%2BhEkmjzCm04aPKzIq8QH4x9F0j2SsNVk5QBnCUBxkwH50BO8p%2FGfhV94RH90weBYj0CDYYYOa5tUxXhiQTkWOCguL0lQa7bJNBZQIGxgn%2BSaZQ%2FOYx9U%2B%2BJz4notoI80AnVcZcWVsYmrawfd33VtSQ9Fb6LJ7U%2F2hcpdmTDobQGsCD%2FSh9zKfiun5zZ6zJb7ZewR%2B1RAnLvz5yFHI%2BDmhy5lr9G48stGqqNHA2D0cpCJoVgww5OhV0z3HAdAy8u5B7L4B%2B3gORRfjupp5SZV3w7XeUH56%2BtHLg08qFIO%2BZGwxi%2FhfddMX4T9Co0Bgl6X8ggYgTjzlKwp2nwYKq0pOMJfnzZUGOpkB5dvfdXmV4ZB9Z2oj7mUl6nbmZdrS7kj%2FcL4rlaiYwxGBJ%2F8x4RPLd%2BuvCURQzsDCe2OyqINpBQ9eY%2B0suZAx0bDsVsJFhOe7NlGnySTRwRc9ldVo2L8n5VfubnNjfYmIlrrcUXQO1r2SF%2B8GJI434klRgEbctpB%2F6C4peXMMDXm8GBzE2nqdZxgRHgKOKqHp3CxMu0Gx3FYZ&Expires=1655931306")
            )
        }
    }

}
