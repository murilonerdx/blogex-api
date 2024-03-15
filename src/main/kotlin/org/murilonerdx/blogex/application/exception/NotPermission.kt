package org.murilonerdx.blogex.application.exception

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

class NotPermission(id: String) : RuntimeException("User not permisson to delete item by id $id") {
}