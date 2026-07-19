import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<CommonExtension<*, *, *, *, *, *>>()
            extension.apply {
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.10" // Оновіть відповідно до версії Compose
                }
            }

            dependencies {
                val bom = extensions.getByType<org.gradle.api.artifacts.VersionCatalogsExtension>().named("libs").findLibrary("androidx-compose-bom").get()
                add("implementation", platform(bom))
                add("implementation", extensions.getByType<org.gradle.api.artifacts.VersionCatalogsExtension>().named("libs").findLibrary("androidx-ui-tooling-preview").get())
                add("debugImplementation", extensions.getByType<org.gradle.api.artifacts.VersionCatalogsExtension>().named("libs").findLibrary("androidx-ui-tooling-preview").get())
            }
        }
    }
}