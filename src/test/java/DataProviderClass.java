import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "fileDataProvider")
    public Object[][] provideData() {
        return new Object[][] { { "registerData.json" }, { "loginData.json" } };
    }
}

