package com.undefined.undefined;

import com.undefined.undefined.feign.FeignClientRequestCurrency;
import com.undefined.undefined.feign.FeignClientRequestGiphy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@ActiveProfiles("servicetest")
@AutoConfigureMockMvc
public abstract class AbstractTest {

//    protected static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>(
//            DockerImageName.parse("postgres:9.6")
//                    .asCompatibleSubstituteFor("postgres"))
//            .withReuse(true);
//
//    @DynamicPropertySource
//    static void postgresProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
//        registry.add("spring.datasource.username", POSTGRES::getUsername);
//        registry.add("spring.datasource.password", POSTGRES::getPassword);
//    }
//
//    @BeforeAll
//    public static void beforeAll() {
//        POSTGRES.start();
//    }

    @MockBean
    protected FeignClientRequestCurrency feignClientRequestCurrency;

//    @MockBean
//    protected FeignClientRequestGiphy feignClientRequestGiphy;
}

