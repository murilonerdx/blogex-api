package org.murilonerdx.blogex.application.exception

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

class LoginInvalidException() : RuntimeException("Please ready with github") {
}