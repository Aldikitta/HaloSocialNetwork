plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
    alias(libs.plugins.com.google.protobuf)
}

android {
    namespace = "com.aldikitta.datastore"
}

protobuf {
    protoc {
        artifact = libs.com.google.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val java by registering {
                    option("lite")
                }
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.javax.inject.javax.inject)

    //Datastore-Protobuf
    implementation(libs.androidx.datastore.datastore)
    implementation(libs.com.google.protobuf.protobuf.kotlinlite)
    implementation(libs.com.google.protobuf.protobuf.javalite)
}