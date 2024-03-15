package org.murilonerdx.blogex.infra.config

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class LocaleConfiguration {
    @PostConstruct
    fun timezoneConfig() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
    }
}