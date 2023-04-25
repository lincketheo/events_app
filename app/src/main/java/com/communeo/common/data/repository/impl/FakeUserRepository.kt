package com.communeo.common.data.repository.impl

import com.communeo.common.data.models.user.PublicUser
import com.communeo.common.data.repository.UserRepository

class FakeUserRepository : UserRepository {

    companion object {
        val publicUsers: Set<PublicUser> = (0..50).map {
            PublicUser.random()
        }.toSet() + setOf(PublicUser("Bob"))

        fun randomUser() = publicUsers.random()
    }

    override suspend fun getUser(name: String): PublicUser? {
        return try {
            val matches = publicUsers.filter { it.name == name }
            if (matches.size > 1) {
                print("Multiple users have the name $name, returning the first")
            }
            matches[0]
        } catch (e: IndexOutOfBoundsException) {
            print("Requested user doesn't exist")
            null
        }
    }
}
