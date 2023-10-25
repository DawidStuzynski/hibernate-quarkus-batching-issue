import io.quarkus.arc.Unremovable
import io.quarkus.credentials.CredentialsProvider
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named

@Unremovable
@ApplicationScoped
@Named("custom-credentials-provider")
internal class CustomCredentialsProvider : CredentialsProvider {

    override fun getCredentials(credentialsProviderName: String?): Map<String?, String?>? {
        val properties: MutableMap<String?, String?> = HashMap()
        properties[CredentialsProvider.USER_PROPERTY_NAME] = "TEST_USERNAME"
        properties[CredentialsProvider.PASSWORD_PROPERTY_NAME] = "TEST_PASSWORD"
        return properties
    }
}
