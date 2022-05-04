import com.example.koinlearning.MainRepository
import com.example.koinlearning.MainRepositoryImpl
import com.example.koinlearning.MyApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    // factory will create new instance where it is requested
    factory {
        MainRepositoryImpl(get())
    }
}