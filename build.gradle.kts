plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// JPA - Postgres
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")

	// Redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("redis.clients:jedis")

	// MongoDB
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// Security
	implementation("org.springframework.boot:spring-boot-starter-security")

	// Web
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Validation
	implementation("org.springframework.boot:spring-boot-starter-validation:3.2.1")

	// Websocket
	implementation("org.springframework.boot:spring-boot-starter-websocket")

	// Devtools
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// JetBrains Annotations
	implementation("org.jetbrains:annotations:24.1.0")

	// Documentation
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	// Mapping framework
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
