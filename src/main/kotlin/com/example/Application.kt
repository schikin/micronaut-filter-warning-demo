package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.RequestFilter
import io.micronaut.http.annotation.ServerFilter
import io.micronaut.runtime.Micronaut.run
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@ServerFilter("/**")
class SomeFilter {
	@RequestFilter
	@ExecuteOn(TaskExecutors.BLOCKING)
	fun filterRequest(request: HttpRequest<*>) {

	}
}

@Controller
class Controller {
	@Post("/upload", consumes = [MediaType.MULTIPART_FORM_DATA])
	fun upload(file: ByteArray) : String {
		return "OK"
	}
}

fun main(args: Array<String>) {
	run(*args)
}

