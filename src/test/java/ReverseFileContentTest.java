
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReverseFileContent.class)
public class ReverseFileContentTest {


   @Test
   public void test_reverseFileContent_is_success_when_all_methods_success() throws Exception {
       ReverseFileContent mock = spy(new ReverseFileContent());
       doReturn("ABC").when(mock, "readFileAndReturnContent", ArgumentMatchers.anyString());
       doNothing().when(mock, "writeToFile", ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
       Boolean isSuccess = mock.reverseFileContent("input.txt", "output.txt");
       Assert.assertTrue(isSuccess);
   }

    @Test
    public void test_reverseFileContent_returns_false_if_readFileAndReturnContent_fails() throws Exception {
        ReverseFileContent mock = spy(new ReverseFileContent());
        doThrow(new RuntimeException()).when(mock, "readFileAndReturnContent", ArgumentMatchers.anyString());
        doNothing().when(mock, "writeToFile", ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
        Boolean isSuccess = mock.reverseFileContent("input.txt", "output.txt");
        Assert.assertFalse(isSuccess);
    }

    @Test
    public void test_reverseFileContent_returns_false_if_writeToFile_fails() throws Exception {
        ReverseFileContent mock = spy(new ReverseFileContent());
        doReturn("ABC").when(mock, "readFileAndReturnContent", ArgumentMatchers.anyString());
        doThrow(new RuntimeException()).when(mock, "writeToFile", ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
        Boolean isSuccess = mock.reverseFileContent("input.txt", "output.txt");
        Assert.assertFalse(isSuccess);
    }

    @Test
    public void test_reverseContent() {
       String actualStr = new ReverseFileContent().reverseContent("ABC");
       String expectedStr = "CBA";
       Assert.assertEquals(expectedStr, actualStr);
    }
}
