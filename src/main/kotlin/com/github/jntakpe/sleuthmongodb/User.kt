package com.github.jntakpe.sleuthmongodb

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

//If you remove the indexed annotation it will work fine
@Document
data class User(@Indexed val username: String, val id: ObjectId? = null): Serializable