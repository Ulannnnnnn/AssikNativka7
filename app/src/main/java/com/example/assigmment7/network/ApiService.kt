package com.example.assigmment7.network

import com.example.assigmment7.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.URL

object ApiService {

    suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO) {
        val url = URL("https://jsonplaceholder.typicode.com/posts")
        val json = url.readText()

        val jsonArray = JSONArray(json)
        val posts = mutableListOf<Post>()

        for (i in 0 until jsonArray.length()) {
            val item = jsonArray.getJSONObject(i)
            posts.add(
                Post(
                    userId = item.getInt("userId"),
                    id = item.getInt("id"),
                    title = item.getString("title"),
                    body = item.getString("body")
                )
            )
        }

        return@withContext posts
    }
}
