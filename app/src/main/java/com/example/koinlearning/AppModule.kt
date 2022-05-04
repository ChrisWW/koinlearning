import com.example.koinlearning.MainRepository
import com.example.koinlearning.MainRepositoryImpl
import com.example.koinlearning.MainViewModel
import com.example.koinlearning.MyApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// single will create singleton so one instance for the whole application
val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    // factory will create new instance where it is requested factory {}
    single<MainRepository> {
        MainRepositoryImpl(get())
    }

    viewModel {
        MainViewModel(get())
    }
}