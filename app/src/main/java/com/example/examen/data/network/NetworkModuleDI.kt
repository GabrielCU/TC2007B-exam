import com.example.examen.data.network.CovidAPIService
import com.example.examen.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Provides a configured instance of `CovidAPIService` for network operations.
 *
 * Utilizes `OkHttpClient` with `HttpLoggingInterceptor` for logging network requests.
 * The `invoke` function sets up Retrofit with a base URL and a Gson converter.
 */
object NetworkModuleDI {

	private val loggingInterceptor = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY // or Level.BASIC, Level.HEADERS, etc., based on your need
	}

	private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
		.addInterceptor(loggingInterceptor)
		.build()

	operator fun invoke(): CovidAPIService {
		return Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(CovidAPIService::class.java)
	}
}
