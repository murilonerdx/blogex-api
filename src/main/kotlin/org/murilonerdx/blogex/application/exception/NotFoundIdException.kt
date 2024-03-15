package org.murilonerdx.blogex.application.exception

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

class NotFoundIdException(id: String) : RuntimeException("Not found model with id $id") {
}