import com.aldikitta.convention.hollahalo.configureKotlinAndroid
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.dokka")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
//                defaultConfig.targetSdkPreview = "UpsideDownCake"
                // TODO This is Flavor
//                configureFlavors(this)
            }
            extensions.configure<ApplicationAndroidComponentsExtension> {
                // TODO This is APK TEST
//                configurePrintApksTask(this)
            }
        }
    }

}