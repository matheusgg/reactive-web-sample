package br.com.sample.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Book(@Id var id: String?, var title: String, var author: String)