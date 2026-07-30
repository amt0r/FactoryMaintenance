import com.factorymaintenance.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }

            configureKotlinJvm()
        }
    }
}